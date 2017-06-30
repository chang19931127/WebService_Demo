package me.czd.ws.soap_cxf;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * JaxWs 客户端 这个客户端就比较灵活
 * 也被称作 静态代理客户端
 * 这个客户端需要 通过 wsdl 来进行打jar 包，然后通过静态代理待调用
 * wsdl2java
 * 
 * @author Administrator
 *
 */
public class JaxWsClient {
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setAddress("http://localhost:8080/ws/soap/hello");
		factory.setServiceClass(HelloService.class);

		HelloService helloService = factory.create(HelloService.class);
		String result = helloService.say("常振东");
		System.out.println(result);
	}
}
