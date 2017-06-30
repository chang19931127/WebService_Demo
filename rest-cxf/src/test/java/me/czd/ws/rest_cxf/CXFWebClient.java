package me.czd.ws.rest_cxf;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.MediaType;

import org.apache.cxf.jaxrs.client.WebClient;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * 这种方式 我们应该推崇
 * 虽说跟 JAXRS 第二代很想，但是 这是大势所趋，迭代编程，函数式编程
 * 
 * 使用过的是CXF 不过关于 client 的调用 有很多框架可以来 例如 okhttp httpClient
 * 
 * @author Administrator
 *
 */
public class CXFWebClient {
	public static void main(String[] args) {
		String baseAddress = "http://localhost:8080/ws/rest/";

		List<Object> providerList = new ArrayList<Object>();
		providerList.add(new JacksonJsonProvider());

		List productList = WebClient.create(baseAddress, providerList).path("/products")
				.accept(MediaType.APPLICATION_JSON).get(List.class);
		for (Object product : productList) {
			System.out.println(product);
		}
	}
}
