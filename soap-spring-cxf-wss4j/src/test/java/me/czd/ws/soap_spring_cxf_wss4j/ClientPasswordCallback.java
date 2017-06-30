package me.czd.ws.soap_spring_cxf_wss4j;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.springframework.stereotype.Component;

/**
 * 客户端回调处理器
 * @author Administrator
 *
 */
@Component
public class ClientPasswordCallback implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
			
		WSPasswordCallback callback = (WSPasswordCallback) callbacks[0];
		//说明密码
		callback.setPassword("clientpass");
	}

}
