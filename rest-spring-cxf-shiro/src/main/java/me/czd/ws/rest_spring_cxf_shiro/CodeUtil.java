package me.czd.ws.rest_spring_cxf_shiro;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 加密的工具类
 * 
 * @author Administrator
 *
 */
public class CodeUtil {
	/**
	 * MD5 加密 然后转16
	 */
	public static String encryptMD5(String source) {
		return new Md5Hash(source).toHex();
	}
}
