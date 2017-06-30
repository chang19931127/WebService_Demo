package me.czd.ws.rest_cxf;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * rest 服务的接口， 套用别人的名词，服务就是提供方，就是生产方 这里使用了java RS 的规范，毕竟java 的 标准规范
 * 
 * retrieve 取回 程序员英语也不能落后
 * 
 * 这里可以说 是关于 Product 的一套操作
 * 
 * @author Administrator
 *
 */
public interface ProductService {

	//获取所有 product 用复数 uri
	@GET
	@Path("/products")
	@Produces(MediaType.APPLICATION_JSON)
	List<Product> retrieveAllProducts();

	//通过id 来获取 product
	@GET
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Product retrieveProductById(@PathParam("id") long id);

	//通过表单提交来 根据name 获取products
	@POST
	@Path("/products")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	List<Product> retrieveProductsByName(@FormParam("name") String name);

	//通过 post 来创建 product
	@POST
	@Path("/product")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Product createProduct(Product product);

	//通过 put 来进行 某个id 的更新
	@PUT
	@Path("/product/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	Product updateProductById(@PathParam("id") long id, Map<String, Object> fieldMap);

	//通过 delete 来进行 某个id 的删除
	@DELETE
	@Path("/product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Product deleteProductById(@PathParam("id") long id);

}
