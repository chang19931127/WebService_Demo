package me.czd.ws.soap_spring_cxf_wss4j;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.stereotype.Component;

/**
 * 用于InInterceptor 的回调函数
 * 
 * 要给spring发现
 * 
 * 实现的是j s 提供的安全回调接口 这里 将java提供的 转化成了 wss4j提供的，其实他们有着莫名的关系
 * 
 * @author Administrator
 *
 */
@Component
public class ServerPasswordCallback implements CallbackHandler{

	//提供一个校验的身份认证，写死
	private static final Map<String, String> userMap = new HashMap<>();
	
	//静态方法初始化
	static{
		userMap.put("client", "clientpass");
		userMap.put("server", "serverpass");
	}
	
	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
		WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];
		
		String clientUsername = callback.getIdentifier(); //认证
		String serverPassword = userMap.get(clientUsername);
		
		//基于用户口令的校验
		if(serverPassword != null ){
			callback.setPassword(serverPassword);
		}
	}

}
