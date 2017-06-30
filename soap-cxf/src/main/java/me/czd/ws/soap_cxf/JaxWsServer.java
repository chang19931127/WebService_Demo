package me.czd.ws.soap_cxf;

import java.util.logging.Logger;

import org.apache.cxf.jaxws.JaxWsServerFactoryBean

;

/**
 * 使用JaxWS来进行 server 的发布
 * 
 * XXXxxFactoryBean
 * 
 * @author Administrator
 * 
 *
 */
public class JaxWsServer {
	private final static Logger log = Logger.getLogger(JaxWsServer.class.getName());

	public static void main(String[] args) {
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		factory.setAddress("http://localhost:8080/ws/soap/hello");
		factory.setServiceClass(HelloService.class);
		factory.setServiceBean(new HelloServiceImpl());
		factory.create();
		log.info("jax ws server provide soap ws is publish");
	}
}
