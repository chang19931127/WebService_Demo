package me.czd.ws.soap_cxf;

import javax.jws.WebService;

/**
 * 
 * 暴露出去的Service 学术称为 Endpoint 端点
 * 暴露的方法是WS方法 学术称为 Operation 操作
 * 
 * 无论使用什么框架，我们都会去遵守规范，这里的规范就是  jws的规范
 * 
 * @WebService jws 的
 * @author Administrator
 *
 */
@WebService
public interface HelloService {
	String say(String name);
}
