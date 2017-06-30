package me.czd.ws.soap_cxf;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * 动态代理  这个方案无需wsdl 进行打包 其实就是使用jdk 的动态代理来做了一个简单的封装
 * 
 * @author Administrator
 *
 */
public class JaxWsDynamicClient {
	public static void main(String[] args) {
		JaxWsDynamicClientFactory factory = JaxWsDynamicClientFactory.newInstance();
		Client client = factory.createClient("http://localhost:8080/ws/soap/hello?wsdl");

		// 其实这里就是通过反射调用方法
		try {
			Object[] results = client.invoke("say", "常振东");
			System.out.println(results[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
