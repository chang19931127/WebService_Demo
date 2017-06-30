package me.czd.ws.soap_jdk_web;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * 
 * 这里是基于动态代理来进行的ws 调用
 * 
 * 同样适用的是 jdk 动态代理
 * 
 * @author Administrator
 *
 */
public class DynamicClient {
	private static final Logger log = Logger.getLogger(DynamicClient.class.getName());

	public static void main(String[] args) {
		try {
			URL wsdl = new URL("http://localhost:8080/soap-jdk-web/ws/soap/hello?wsdl");
			//这里的url 一定要写对。这里就不需要 去生成jar 了，而是直接通过代理 然后 直接wsdl 进行获取
			QName serviceName = new QName("http://soap_jdk_web.ws.czd.me/", "HelloService");
			QName portName = new QName("http://soap_jdk_web.ws.czd.me/", "HelloServicePort");
			Service service = Service.create(wsdl, serviceName);

			HelloService helloService = service.getPort(portName, HelloService.class);

			String result = helloService.say("理查德");
			log.info(result);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}
}
