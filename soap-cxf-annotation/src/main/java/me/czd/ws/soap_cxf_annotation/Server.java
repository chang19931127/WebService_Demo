package me.czd.ws.soap_cxf_annotation;

import java.util.logging.Logger;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

/**
 * 来发布ws
 * 
 * @author Administrator
 *
 */
public class Server {
	private static final Logger log = Logger.getLogger(Server.class.getName());

	public static void main(String[] args) {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setAddress("http://localhost:8080/ws/soap/hello");
		factory.setServiceClass(HelloService.class);
		factory.setServiceBean(new HelloServiceImpl());
		factory.create();
		log.info("soap ws is publish 这里使用了 cxf 注解来注解到Service中");
	}
}
