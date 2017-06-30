
/**
 * 当然cxf 不仅仅支持    soap 方式的 ws
 * 还支持现在比较火热的rest 方式的 ws
 * 
 * rest 表述性状态转移
 * 可以是json可以使atom可以使xml 资源状态转移
 * rest 是一种 抛出web服务的架构方式
 * 面向资源 通过uri 来进行资源的定位
 * 
 * 
 * javaee 的 rest 方案 JAX-RS，可以说不是太完整的 rest
 * 正儿八经的rest 有很多规范，在自己去了解吧
 * 
 * rest 就不用介绍了，项目用的比价多，和 http比较亲和
 * 直接看怎么通过 cxf 来发布rest 的ws 服务吧
 * 
 * 使用cxf如何发布rest呢
 * 
 * maven工程，先来pom
 * 
 * 先定义一个rest 接口吧
 * 
 * 使用cxf 来发布 api
 * 
 * 使用 cxf客户端来调用
 * 
 * 
 */
package me.czd.ws.rest_cxf;

