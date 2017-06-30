package me.czd.ws.soap_jdk;


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
	 * 
	 * Client 如何来进行？
	 * 
	 * 通过浏览器，我们都知道很简单，但是如何通过客户端调用呢
	 * 这里我们使用jdk 提供的命令行工具来 生成ws 客户端调用的jar 包
	 * 
	 * jdk安装目录下 bin 目录中的 wsimport命令行可以帮助我们
	 * 
	 * 命令如下
	 * wsimport http://localhost:8080/ws/soap/hello?wsdl      	通过wsdl生成class文件 
	 * jar cvf client.jar * 										通过jar 命令来打包
	 * rmdir /s/q me					 删除me文件夹
	 * 这样就可以得到一个client.jar
	 * 
	 * resource 有我写的一个简单的 bat文件
	 * 
	 * 我们导入这个jar
	 * 
	 */
}
