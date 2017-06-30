package me.czd.ws.soap_cxf_annotation;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * 使用方便的 动态客户端JaxWs来进行 获取ws
 * @author Administrator
 *
 */
public class Client {
	public static void main(String[] args) {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("http://localhost:8080/ws/soap/hello");
        factory.setServiceClass(HelloService.class);

        HelloService helloService = factory.create(HelloService.class);
        String result = helloService.say("world");
        System.out.println(result);
	}
}
