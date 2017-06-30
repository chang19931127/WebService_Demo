package me.czd.ws.soap_cxf;

import java.util.logging.Logger;

import org.apache.cxf.frontend.ServerFactoryBean;

/**
 * 使用简单的方式发布
 * 
 * XXXXXFactoryBean 这种命名 方式要学习
 * 
 * http://localhost:8080/ws/soap/hello?wsdl 访问
 * simple 发布的server 必须使用simple 的客户端来进行 获取
 * 
 * @author Administrator
 *
 */
public class SimpleServer {
	private static final Logger log = Logger.getLogger(SimpleServer.class.getName());

	public static void main(String[] args) {
		ServerFactoryBean factory = new ServerFactoryBean();
		factory.setAddress("http://localhost:8080/ws/soap/hello");
		factory.setServiceClass(HelloService.class);
		factory.setServiceBean(new HelloServiceImpl());
		factory.create();
		log.info("simpleServer privide soap ws is publish");

	}
}
