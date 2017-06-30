package me.czd.ws.soap_jdk;

import java.util.logging.Logger;

import javax.xml.ws.Endpoint;

/**
 * 光有接口也不行，我们需要将这些端点暴露出去 我们需要一个程序来帮助我们暴露出去
 * 
 * 使用EndPoint来进行发布
 * 
 * 我们通过浏览器访问或者客户端     http://localhost:8080/ws/soap/hello?wsdl
 * 
 * 只有你发布了，别人才可以去访问，这里直接通过Endpoint 就直接发布到地址中了，并没有依赖容器，等等
 * 
 * 就会通过wsdl 来获得xml文档
 * 
 * @author Administrator
 *
 */
public class Server {

	private static final Logger log = Logger.getLogger(Server.class.getName());

	public static void main(String[] args) {
		// 最让人熟悉的方式
		String address = "http://localhost:8080/ws/soap/hello";
		HelloService helloService = new HelloServiceImpl();

		Endpoint.publish(address, helloService);
		log.info("soap webservice is published!!!!");
	}
}
