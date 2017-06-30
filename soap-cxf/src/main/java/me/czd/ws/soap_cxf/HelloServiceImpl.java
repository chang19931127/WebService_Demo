package me.czd.ws.soap_cxf;

import javax.jws.WebService;

/**
 * 相对应的 WS 接口的实现类
 * 
 * 注解的内容，就是见名知意，自己理解下
 * cxf 提供了默认配置
 * 
 * @author Administrator
 *
 */
@WebService
public class HelloServiceImpl implements HelloService {

	public String say(String name) {
		return "hello。" + name + "本服务由cxf 提供";
	}

}
