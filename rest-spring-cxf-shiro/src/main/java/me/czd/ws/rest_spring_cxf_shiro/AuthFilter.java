package me.czd.ws.rest_spring_cxf_shiro;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.model.OperationResourceInfo;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.apache.shiro.authz.aop.AuthenticatedAnnotationHandler;
import org.apache.shiro.authz.aop.AuthorizingAnnotationHandler;
import org.apache.shiro.authz.aop.GuestAnnotationHandler;
import org.apache.shiro.authz.aop.PermissionAnnotationHandler;
import org.apache.shiro.authz.aop.RoleAnnotationHandler;
import org.apache.shiro.authz.aop.UserAnnotationHandler;
import org.springframework.stereotype.Component;

/**
 * 提供授权 过滤 ContainerRequestFilter 的实现类 这样子好整合到 cxf provider
 * 
 * 这里通过shiro 来进行访问控制
 * 
 * 这里的逻辑有点复杂 首先 注册了 注解和 注解处理器的关系
 * 
 * 然后我们试图 获取当前请求目标的方法，通过这个方法来确定方法中的 注解，然后 将这些注解 来获取对应的处理器 然后使用处理器 去处理 请求 进行授权
 * 
 * @author Administrator
 *
 */
@Component
public class AuthFilter implements ContainerRequestFilter {
	
	private Logger log = Logger.getLogger(AuthFilter.class);
	
	/**
	 * 定义 shiro 权限注解 和注解处理器之间的映射关系，存储到一个map中 LinkedHashMap 是一个能记住 put 顺序的集合
	 */
	private static Map<Class<? extends Annotation>, AuthorizingAnnotationHandler> shiroAnnotationMap = new LinkedHashMap<>();

	static {
		// 来添加映射关系 这些都是 认证，然后为了授权
		shiroAnnotationMap.put(RequiresAuthentication.class, new AuthenticatedAnnotationHandler());
		shiroAnnotationMap.put(RequiresUser.class, new UserAnnotationHandler());
		shiroAnnotationMap.put(RequiresGuest.class, new GuestAnnotationHandler());
		shiroAnnotationMap.put(RequiresRoles.class, new RoleAnnotationHandler());
		shiroAnnotationMap.put(RequiresPermissions.class, new PermissionAnnotationHandler());
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// 获取目标方法
		Method method = getTargetMethod();
		// 获取shiro 注解
		Set<Annotation> annotationSet = getShiroAnnotationSet(method);
		for (Annotation annotation : annotationSet) {
			// 创建Shir 注解处理器 授权处理器
			AuthorizingAnnotationHandler handler = getAuthorizingAnnotationHandler(annotation);
			try {
				handler.assertAuthorized(annotation);
			} catch (AuthorizationException e) {
				handlerException(requestContext, e);
			}

		}
	}

	private Method getTargetMethod() {
		Message message = JAXRSUtils.getCurrentMessage();
		Exchange exchange = message.getExchange();
		OperationResourceInfo operationResourceInfo = exchange.get(OperationResourceInfo.class);
		return operationResourceInfo.getAnnotatedMethod();
	}

	/**
	 * 通过方法 来获取 注解集
	 */
	private Set<Annotation> getShiroAnnotationSet(Method method) {
		Set<Annotation> annotationSet = new LinkedHashSet<>();
		Class<?> clazz = method.getDeclaringClass();
		addClassAnnotation(annotationSet, clazz);
		addMethodAnnotation(annotationSet, method);
		return annotationSet;
	}

	/**
	 * 如果类中有这个注解，就添加到set
	 */
	private void addClassAnnotation(Set<Annotation> annotationSet, Class<?> clazz) {
		for (Class<? extends Annotation> shiroAnnotationClass : shiroAnnotationMap.keySet()) {
			if (clazz.isAnnotationPresent(shiroAnnotationClass)) {
				annotationSet.add(clazz.getAnnotation(shiroAnnotationClass));
			}
		}
	}

	/**
	 * 获取授权 注解处理器
	 */
	private AuthorizingAnnotationHandler getAuthorizingAnnotationHandler(Annotation annotation) {
		return shiroAnnotationMap.get(annotation.annotationType());
	}

	/**
	 * 如果 方法中有 这个注解，就添加到 set中
	 */
	private void addMethodAnnotation(Set<Annotation> annotationSet, Method method) {
		for (Class<? extends Annotation> shiroAnnotationClass : shiroAnnotationMap.keySet()) {
			if (method.isAnnotationPresent(shiroAnnotationClass)) {
				annotationSet.add(method.getAnnotation(shiroAnnotationClass));
			}
		}
	}

	/**
	 * 处理异常 这里的 enum 写的很好，直接借鉴 enum 实现一个接口，来给所有对象 添加方法
	 */
	private void handlerException(ContainerRequestContext requestContext, AuthorizationException e) {
		// 返回状态吗
		int code;
		if (e instanceof UnauthenticatedException) {
			// 认证失败 401
			code = Response.Status.UNAUTHORIZED.getStatusCode();
			log.warn("认证失败！！！！！！");
		} else if (e instanceof UnauthorizedException) {
			// 授权失败 403
			code = Response.Status.FORBIDDEN.getStatusCode();
			log.warn("授权失败！！！！！！！");
		} else {
			throw new IllegalStateException("can not support this exception: " + e.getClass().getName(), e);
		}
		requestContext.abortWith(Response.status(code).build());
	}
}
