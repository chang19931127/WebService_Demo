
/**
 * @author Administrator
 * 
 * 有没有考虑过之前我们发布的 ws 只要是一个用户就可以去访问并且调用
 * 这样子是不是很不安全
 * 那么如何来使我们的ws更加健壮，安全呢
 * 
 * 这里来几个概念
 * wsdl   用来描述ws是什么
 * soap   用来表示ws里有什么
 * 
 * 这里soap协议 和 http协议就不谋而合
 * 如果想要使用注解来控制ws 的话，需要将注解放到 ws的实现类上面
 * 
 * 无论加不加密  url?wsdl都可以访问，但是安全控制管理的是能不能调用的问题
 * 
 * 代码结构，正常没有认证 spring-cxf-1.xml and spring-client-1.xml
 * 
 * 基于soap的 安全控制 java业界的可靠框架 WSS4J WS-Security
 * 认证ws请求，加密soap消息
 * 认证：	1，用户令牌的身份认证
 * 			2，数字签名的身份认证
 * 有更多的类库来实现安全控制，shiro spring security
 * 加密：	soap消息加密，解密
 * 
 * 下面就介绍如何来集成 wss4j 到我们的 czf和spring的环境中
 * 
 * maven 再次走起  pom 看一遍
 * 
 * web.xml走一遍
 * 
 * 开始，
 * 用户令牌的身份认证 就是密码校验
 * 1，需要暴露的ws 
 * 2，cxf进行发布设置       需要一个WSS4JIninterceptor 这个拦截器，来帮助我们拦截请求 设置令牌
 * 		发布的时候加入拦截器   拦截器中给一个回调函数的属性CallbackHandler 
 * 3.cxf 进行客户端的调用 也要有一个输出拦截器，  当然配置文件的 user 和 输出拦截器的密码一定要对应
 * 4,拦截器的构造可以修改参数值，来实现拦截器的特殊处理，明文传递，等等
 * 项目结构 spring-cxf-2.xml and spring-client-2.xml
 * 
 * 基于数字签名的身份认证      就是公钥私钥，自己的私钥进行签名，别人的公钥进行验签
 * 1，生成密钥库 写好的bat keystore.bat   然后将公钥私钥，放到服务端和客户端
 * 2，cxf进行发布配置             使用 公钥
 * 3，cxf进行客户端调用         使用私钥                     
 * 服务器公钥，客户端私钥
 * 项目结构，spirng-cxf-3.xml and spring-client-3.xml
 * 
 * 前面只是针对访问控制进行了处理，但是  soap中的请求依旧是可见的有时候也会不安全，那么如何解决  上面是认证，这里是加密
 * 
 * soap消息的加密与解密
 * 1，配置服务端   加密
 * 2，配置客户端   解密
 * 看浏览 ?wsdl的变化
 * 项目结构，spirng-cxf-4.xml and spring-client-4.xml
 */
package me.czd.ws.soap_spring_cxf_wss4j;