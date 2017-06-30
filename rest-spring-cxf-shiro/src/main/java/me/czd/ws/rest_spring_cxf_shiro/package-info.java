
/**
 * 
 * 同样是ws 无论是rest 还是soap 都需要进行 权限控制，或者加密
 * 因为我们不可能无偿提供服务，或者随便提供服务，
 * 这里我们使用的是  比较常用的shiro 框架来做安全框架
 * 
 * spring - cxf - shiro - rest 服务
 * shiro 和spring 整合的时候，其实shiro是一堆过滤器
 * 那么如何整合到spring 通过 DelegatingFilterProxy      过滤器栈
 * 
 * shiro 简单说一下 	1，总体实现 通过过滤器链 和spring 集成 DelegatingFilterProxy
 * 					2，要有一个securityManager   这里面有realm管理数据，cacheManager管理缓存
 * 					3，就是我们需要的过滤器ShiroFilterFactoryBean
 * 							通过这个可以来过滤，请求，url的控制，成功失败的处理 方然要将我们的securityManager加入
 * 					4，针对java类的 方法通过注解来进行控制 但是注解要注册对应的注解处理器 
 * 这里和spring security 类似
 * 
 * maven 工程
 * pom and web.xml
 * 然后走你
 * 
 * 1，构造资源          				这里的资源我们通过shiro注解进行了权限的控制
 * 2，发布资源
 * 3，整合安全
 * 4，访问资源
 * 
 * 前台js 通过封装crud 到一个ProductService 对象中，然后通过这个对象去调用
 * 三个区别就是  前台js 代码的区别，封装模板到工具类，等等 AJAX请求也封装，让代码更加好看
 * 
 * 
 * 
 * 这里逻辑分的很清楚
 * spring.xml 			spring的整合
 * spring-cxf.xml		cxf进行rest的发布
 * spring-shiro.xml		安全的具体管理
 * 
 * AuthFilter  		cxf 发布使用的
 * CodeUtil			加密的工具类
 * MyMatcher		比较器，用来比较密码是否相等   表单提交提交和Realm
 * MyRealm 			这里通过 Usedao 来获取 密码              这里注入了 MyMatcher 和 UserDao
 * 				shiro 通过realm 这一层来进行 数据交互的那一层概念 通过realm读取用户数据用于认证和授权
 * 				主要是获取表单token 和 后台信息  然后交给框架 来进行认证和授权 ，两个对象
 * 				用户密码对象，用户领域对象
 * UserDao			硬性编码，用户密码维护
 *
 *来看下请求结构，首先请求shiro filter  然后在通过cxf filter 最后被 servlet处理
 *
 * 
 * 所有数据放到token 中
 * 
 *
 * 
 * 
 * 一个想法，虽说现在 很多xml配置都可以被注解代替，但是直接将  配置 嵌入到 java代码中，这样子方便维护么，所以请择优考虑
 * 
 */
package me.czd.ws.rest_spring_cxf_shiro;