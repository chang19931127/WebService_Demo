package me.czd.ws.soap_jdk_web;


/**
 * Info
 * 写出服务
 * 发布服务
 * 调用服务
 * ws soap 就是一个rpc
 * @author Administrator
 *
 */
public class Info {
	/**
	 * web 环境下的  ws 如何使用
	 * ws 环境下 需要一个 xml文件
	 * 在WEB-INF文件夹下面
	 * 
	 * 需要一个RI  Oracle JAX-WS RI Reference Implements java官方提供的ws 具体实现
	 * 首先需要下载一套关于 jax 的jar 包
	 * 然后 在tomcat中，引入
	 * config/catalina.properties
	 * common.loader="${catalina.base}/lib","${catalina.base}/lib/*.jar","${catalina.home}/lib","${catalina.home}/lib/*.jar"
	 * 加入我们ri包的jar
	 * 
	 * 其实我们也可以加入到我们的项目 WEB-INF/lib 目录下也可以
	 * 
	 * 其实就是WSServletContextListener 进行了监听 
	 * 
	 * http://localhost:8080/soap-jdk-web/ws/soap/hello
	 * 就会出现很多内容，其实是被 ri 进行了发布，里面有专门的的 ws 监听器
	 */
}
