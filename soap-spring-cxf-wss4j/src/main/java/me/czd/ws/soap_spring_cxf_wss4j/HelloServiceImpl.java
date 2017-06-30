package me.czd.ws.soap_spring_cxf_wss4j;

import javax.jws.WebService;

import org.springframework.stereotype.Service;

/**
 * 相对应的 WS 接口的实现类
 * 
 * 
 * @Service注解来注册
 * 
 * @author Administrator
 *
 */
@WebService
@Service
public class HelloServiceImpl implements HelloService {

	public String say(String name) {
		return "hello：" + name + "本服务由cxf 提供  集成到sprling中   并且由tomcat 提供发布服务 而且还通过 Interceptor 进行了安全认证";
	}

}
