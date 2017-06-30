package me.czd.ws.soap_cxf;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.message.Message;

/**
 * 使用 基于拦截器的功能的 Server 来发布ws 这个拦截器是 cxf 的
 * 
 * 这里发布了ws 服务后，如果有客户端调用这里的ws 就会在这里通过日志的方式来进行拦截记录
 * 
 * @author Administrator
 *
 */
public class JaxWsServerWithInterceptor {
	public static void main(String[] args) {
		// 输入拦截器
		List<Interceptor<? extends Message>> inInterceptorList = new ArrayList<>();
		inInterceptorList.add(new LoggingInInterceptor());

		// 输出拦截器
		List<Interceptor<? extends Message>> outInterceptorList = new ArrayList<>();
		outInterceptorList.add(new LoggingOutInterceptor());

		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setAddress("http://localhost:8080/ws/soap/hello");
		factory.setServiceClass(HelloService.class);
		factory.setServiceBean(new HelloServiceImpl());
		// 设置输入拦截器
		factory.setInInterceptors(inInterceptorList);
		// 设置输出拦截器
		factory.setOutInterceptors(outInterceptorList);
		factory.create();

		System.out.println("jaxWs 拥有拦截器的 ws  soap ws is publish");
	}
}
