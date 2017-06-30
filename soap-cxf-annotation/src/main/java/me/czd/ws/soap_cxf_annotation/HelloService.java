package me.czd.ws.soap_cxf_annotation;

import javax.jws.WebService;

import org.apache.cxf.annotations.Logging;
import org.apache.cxf.interceptor.InInterceptors;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.interceptor.OutInterceptors;

/**
 * 
 * 暴露出去的Service 学术称为 Endpoint 端点 暴露的方法是WS方法 学术称为 Operation 操作
 * 
 * 无论使用什么框架，我们都会去遵守规范，这里的规范就是 jws的规范
 * 
 * 这里通过 cxf 的一些注解，来让我们的ws 更加有趣，内容更加丰富也就是cxf增强了ws 就如同我们之前的那个在Server 中进行了
 * 功能的绑定，其实这些东西可以直接放到我们的ws 提供的 Service中
 * 
 * 这里一个建议就是 Interceptor 直接用 class 来替换多好 尴尬，人家提供的有
 * 
 * @WebService jws 的
 * @author Administrator
 *
 */
@WebService
@InInterceptors(interceptors = "org.apache.cxf.interceptor.LoggingInInterceptor")
@OutInterceptors(classes = { LoggingOutInterceptor.class })
@Logging
public interface HelloService {
	String say(String name);
}
