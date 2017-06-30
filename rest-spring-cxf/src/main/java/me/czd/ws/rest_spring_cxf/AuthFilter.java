package me.czd.ws.rest_spring_cxf;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.jaxrs.utils.JAXRSUtils;
import org.apache.cxf.message.Message;
import org.springframework.stereotype.Component;

/**
 * 认证了，让我们信任的去访问
 * 
 * 来进行 认证
 * 
 * @author Administrator
 *
 */
@Component
public class AuthFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		//使用basic 来认证
		Message message = JAXRSUtils.getCurrentMessage();
		AuthorizationPolicy policy = message.get(AuthorizationPolicy.class);
		if (policy == null) {
			login(requestContext);
		} else {
			String username = policy.getUserName();
			System.out.println("username:"+username);
			String password = policy.getPassword();
			System.out.println("password:"+password);
			if (!isAuthenticated(username, password)) {
				login(requestContext);
			}
		}
	}

	private void login(ContainerRequestContext requestContext) {
		requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
				.header(HttpHeaders.WWW_AUTHENTICATE, "Basic realm=Demo").build());
	}

	// 模拟认证
	private boolean isAuthenticated(String username, String password) {
		return "admin".equals(username) && ("admin").equals(password);
	}
}
