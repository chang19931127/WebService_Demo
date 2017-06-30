package me.czd.ws.soap_spring_cxf;

import javax.jws.WebService;


/**
 * 这里我们使用jdk 来发布ws jdk 提供了注解，我们要知道，一般我们暴露出去的都是接口
 * 暴露出去的Service 学术称为 Endpoint 端点
 * 暴露的方法是WS方法  学术称为 Operation 操作
 * 
 * 这里我们是web 环境
 * 
 * @WebService jws 的
 * @author Administrator
 *
 */
@WebService
public interface HelloService {
	String say(String name);
}
