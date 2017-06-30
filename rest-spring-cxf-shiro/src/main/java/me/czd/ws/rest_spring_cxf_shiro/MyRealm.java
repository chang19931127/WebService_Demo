package me.czd.ws.rest_spring_cxf_shiro;

import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Realm 的领域
 * 用来 帮助我们记性密码比对的
 * 继承 AuthorizingRealm 
 * @author Administrator
 *
 */
@Component
public class MyRealm extends AuthorizingRealm  {
	
	@Autowired
	private UserDao userDao;
	
	//根据类型注入 MyMatcher
	@Autowired
	public MyRealm(CredentialsMatcher matcher){
		super(matcher);
	}
	
	//认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		//获取表单提交过来的数据
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		//获取用户名
		String username = usernamePasswordToken.getUsername();
		//根据用户名查询出密码 加密过的
		String password = userDao.queryPassword(username);
		//根据用户名和密码封装的对象  传递给 mathcer
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo();
		info.setPrincipals(new SimplePrincipalCollection(username, super.getName()));
		info.setCredentials(password);
		return info;
	}
	
	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取用户名
		String username = (String) super.getAvailablePrincipal(principals);
		//获取角色名集合
		Set<String> roleNameSet = userDao.queryRoleNameSet(username);
		//获取权限名集合
		Set<String> permissionNameSet = userDao.queryPerMissionNameSet(username);
		//返回角色名集合和权限名集合封装的对象
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		info.setRoles(roleNameSet);
		info.setStringPermissions(permissionNameSet);
		return info;
	}

	
	
}
