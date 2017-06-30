package me.czd.ws.rest_spring_cxf_shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.stereotype.Component;

/**
 * 比较器，用来比较密码是否相同
 * 继承 SimpleCredentialsMatcher 
 * @author Administrator
 *
 */
@Component
public class MyMatcher extends SimpleCredentialsMatcher  {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		//加密后由表单提交过来的密码
		String tokenPassword = CodeUtil.encryptMD5(super.toString(token.getCredentials()));
		//从REALM 中传过来密码    两个进行比对
		String infoPassword = super.toString(info.getCredentials());
		return tokenPassword.equals(infoPassword);
	}
	
}
