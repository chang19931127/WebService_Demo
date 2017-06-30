
/**
 * CXF 实现 REST 和 spring 框架的整合
 * 
 * REST 中解决的问题 ，跨域    如何解决 cros 和jsonp
 * AJAX不能跨域请求
 * jsonp 是针对js的 解决跨域的方式     只能针对get请求
 * cros 更加强大
 * 
 * 
 * 
 * 同样 maven工程
 * 先来 pom 
 * 再来 web.xml
 * 
 * 1，资源定义
 * 2，资源发布		tomcat看到配置文件进行发布
 * 3，访问资源     		http://localhost:8080/rest-spring-cxf/ws/rest/products
 * spring-cxf.xml 是简单的         
 * spring-cxf-jsonp.xml  配置可以跨域的 通过使用 jsonp  是的我们返回的json 带有一个 callable 然后通过嵌入到 js中使用
 * spring-cxf-cros.xml   使用cros 来进行跨域访问
 * spring-cxf-auth.xml 使用  cxf 来进行简单的 认证，这里是基于basic 的 也就是浏览器弹窗用户名密码认证  密码正确才正确显示，否则继续认证
 * 
 * http://localhost:8080/rest-spring-cxf/ws/rest/XXXX   访问
 * 这里我们并没有借助 springmvc
 * 
 * 总结下，安全控制或者是加密，都是通过 对server 发布的时候就进行了处理，或者是接受请求之前，需要进行验证
 * 一定要明白请求和响应的执行顺序
 * 
 *
 */
package me.czd.ws.rest_spring_cxf;