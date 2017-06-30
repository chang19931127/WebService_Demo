
/**
 * 这里是 cxf 和 spring 的 结合
 * 也就是我们最平常的 spring + tomcat + cxf 更贴近开发环境
 * 
 * 这里我们使用的maven 开发方式
 * 因此 pom 很重要 去看一下
 * 
 * 老样子，先来一个暴露的Service类，但是这里需要注册到spring
 * 
 * web.xml 添加 监听器启动，并且加入CXFServlet来进行 处理请求CXFServlet实现了JAX-WS API 提供了 ws
 * 
 * http://localhost:8080/soap-spring-cxf/ws/soap/hello?wsdl 通过这个链接来访问
 * 
 * 其实 与spring 的整合，就是将我们之前的 通过 代码编程的内容整合到spring 配置文件中了 spring-client-1.xml中
 * 还是需要  JaxWsProxyFactoryBean 类来进行代理
 * 
 * 当然还可以通过配置文件来进行其他的配置， spring-cxf-Xxx中来进行 
 * 记住配置文件适合java代码有对应的！！！！
 * 
 * 厉害了我的哥，通过配置文件来取代了硬编码，请细看配置文件
 * 
 * schemal 约束提供的namespace 是真的奇妙啊当然这些解析类也很奇妙
 * 
 * 配置文件也有，注解也有，功能很全，前后兼容！！！
 * 
 * 只需要修改 spring.xml 中导入的 xml就可以了
 * 
 * 配置文件实现拦截器
 * 
 */
package me.czd.ws.soap_spring_cxf;

