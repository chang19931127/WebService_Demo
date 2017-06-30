package me.czd.ws.rest_cxf;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.ResourceProvider;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

/**
 * 发布 rest api
 * 
 * 这里返回的是java对象，所以涉及到Java对象转化成json
 * 
 * @author Administrator
 *
 */
public class Server {
	public static void main(String[] args) {
		// 添加 ResourceClass
		List<Class<?>> resourceClassList = new ArrayList<>();
		resourceClassList.add(ProductServiceImpl.class);

		// 添加ResourceProvider
		List<ResourceProvider> resourceProviderList = new ArrayList<>();
		resourceProviderList.add(new SingletonResourceProvider(new ProductServiceImpl()));

		// 添加Provider
		List<Object> providerList = new ArrayList<>();
		providerList.add(new JacksonJsonProvider());

		// 发布 REST 服务
		JAXRSServerFactoryBean factory = new JAXRSServerFactoryBean();
		factory.setAddress("http://localhost:8080/ws/rest");
		factory.setResourceClasses(resourceClassList);
		factory.setResourceProviders(resourceProviderList);
		factory.setProviders(providerList);
		factory.create();
		System.out.println("基于 cxf 的 rest 通过 cxf 客户端 进行 发布 publish");
	}
}
