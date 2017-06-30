package me.czd.ws.soap_jdk;

import java.util.logging.Logger;

/**
 * 这里就是使用Client.jar来进行ws 服务的调用
 * 
 * 这里可以理解成代理模式，使用的代理对象来进行 ws代码的调用
 * 
 * 还有另外一种动态代理方式
 * 
 * @author Administrator
 *
 */
public class Client {
	private static final Logger log = Logger.getLogger(Client.class.getName());

	public static void main(String[] args) {
		
		//jar 包的类，根据 wsdl 生成的 类，可以，也就是通过wsdl 然后生成类，然后就可以通过这个类。来得到和 ws 提供的类相同的功能
		HelloService_Service service = new HelloService_Service();
		HelloService helloService = service.getHelloServicePort();

		String result = helloService.say("理查德");

		log.info(result);
	}
}
