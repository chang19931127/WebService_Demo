package me.czd.ws.rest_cxf;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * JAXRS2.0版本
 * 
 * 这种方式已经可以迭代是编程了很好
 * 
 * @author Administrator
 *
 */
public class JAXRS20Client {
	public static void main(String[] args) {
		String baseAddress = "http://localhost:8080/ws/rest";

		JacksonJsonProvider jsonProvide = new JacksonJsonProvider();

		List productList = ClientBuilder.newClient().register(jsonProvide).target(baseAddress).path("/products")
				.request(MediaType.APPLICATION_JSON).get(List.class);

		for (Object product : productList) {
			System.out.println(product);
		}

	}
}
