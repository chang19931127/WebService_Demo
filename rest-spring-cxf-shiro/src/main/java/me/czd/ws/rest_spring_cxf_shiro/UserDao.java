package me.czd.ws.rest_spring_cxf_shiro;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.springframework.stereotype.Repository;

/**
 * 这里硬性编码，来进行后台获取user
 * 
 * MultivaluedMap 是一个一对多的map value 是一个集合 哈哈啊
 * 
 * 
 * @author Administrator
 *
 */
@Repository
public class UserDao {
	private static final Map<String, String> accountMap = new HashMap<>();
	private static final MultivaluedMap<String, String> userRoleMap = new MultivaluedHashMap<>();
	private static final MultivaluedMap<String, String> rolePermissionMap = new MultivaluedHashMap<>();

	// 硬编码来进行赋值
	static {
		accountMap.put("jack", CodeUtil.encryptMD5("jack"));
		accountMap.put("richard", CodeUtil.encryptMD5("richard"));

		userRoleMap.put("richard", Arrays.asList("admin"));
		userRoleMap.put("jack", Arrays.asList("guest"));

		// admin 可以访问的领域      crud 
		rolePermissionMap.put("admin", Arrays.asList("product.c", "product.r", "product.u", "product.d"));
		rolePermissionMap.put("guest", Arrays.asList("product.r"));	
	}
	
	/**
	 * 根据用户名 查询 密码 
	 */
	public String queryPassword(String username){
		return accountMap.get(username);
	}
	
	/**
	 * 根据用户名查询角色
	 */
	public Set<String> queryRoleNameSet(String username){
		return new HashSet<>(userRoleMap.get(username));
	}
	
	/**
	 * 根据用户名查询可以访问的领域 
	 */
	public Set<String> queryPerMissionNameSet(String username){
		Set<String> permissionNameSet = new HashSet<>();
		Set<String> roleNameSet = queryRoleNameSet(username);
		for (String roleName : roleNameSet) {
			Collection<String> permissionNames = rolePermissionMap.get(roleName);
			if(permissionNames != null){
				permissionNameSet.addAll(permissionNames);
			}
		}
		return permissionNameSet;
	}
}
