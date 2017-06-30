package me.czd.ws.soap_cxf;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.dynamic.DynamicClientFactory;

/**
 * 使用动态代理客户端
 * 只需要看懂wsdl 就可以调用，不用管接口什么的
 * 
 * @author Administrator
 *
 */
public class DynamicClient {
	public static void main(String[] args) {
		DynamicClientFactory factory = DynamicClientFactory.newInstance();
		Client client = factory.createClient("http://localhost:8080/ws/soap/hello?wsdl");

		try {
			Object[] results = client.invoke("say", "常振东");
			System.out.println(results[0]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
