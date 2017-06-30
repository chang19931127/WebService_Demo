package me.czd.ws.soap_cxf;

import org.apache.cxf.frontend.ClientProxyFactoryBean;

/**
 * Simpel 的客户端 来进行 ws的 消费
 * 
 * @author Administrator
 *
 */
public class SimpleClient {
	public static void main(String[] args) {
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean();
		factory.setAddress("http://localhost:8080/ws/soap/hello");
		factory.setServiceClass(HelloService.class);
		HelloService helloService = factory.create(HelloService.class);

		String result = helloService.say("常振东");
		System.out.println(result);

	}
}
