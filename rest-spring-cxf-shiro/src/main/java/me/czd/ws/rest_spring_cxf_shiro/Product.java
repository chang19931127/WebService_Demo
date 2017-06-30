package me.czd.ws.rest_spring_cxf_shiro;

/**
 * 模型
 * 模型 可以用 lombok 来简化实体，直接 aop 注解来帮助我们自动生成代码
 * 
 * @author Administrator
 *
 */
public class Product {
	private long id;
	private String name;
	private int price;

	public Product() {
		super();
	}

	public Product(long id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
