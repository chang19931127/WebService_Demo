package me.czd.ws.soap_spring_cxf_wss4j;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户端
 * 
 * simple 发布的 ws 必须要 simple client 来进行获取 不能通过 jaxws 来进行获取
 * 
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-client-4.xml");

		HelloService helloService = context.getBean("helloService", HelloService.class);
		String result = helloService.say("常振东");
		System.out.println(result);
		//close()方法  AbstractApplicationContext 子类中有
		((AbstractApplicationContext) context).close();
	}
}
