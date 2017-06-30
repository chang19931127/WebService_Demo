package me.czd.ws.rest_spring_cxf_shiro;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * 实现类
 * 
 * @author Administrator
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	// 使用集合来 模拟数据存储
	private static final List<Product> productList = new ArrayList<>();

	static {
		productList.add(new Product(1, "iphone", 5000));
		productList.add(new Product(2, "samsung", 4000));
	}

	@Override
	public List<Product> retrieveAllProducts() {
		Collections.sort(productList, (product1, product2) -> {
			return (product2.getId() > product1.getId()) ? 1 : -1;
		});
		return productList;
	}

	@Override
	public Product retrieveProductById(long id) {
		Product targetProduct = null;
		for (Product product : productList) {
			if (product.getId() == id) {
				targetProduct = product;
				break;
			}
		}
		return targetProduct;
	}

	@Override
	public List<Product> retrieveProductsByName(String name) {
		List<Product> targetProductList = new ArrayList<>();
		for (Product product : productList) {
			if (product.getName().contains(name)) {
				targetProductList.add(product);
			}
		}
		return targetProductList;
	}

	@Override
	public Product createProduct(Product product) {
		product.setId(new Date().getTime());
		productList.add(product);
		return product;
	}

	@Override
	public Product updateProductById(long id, Map<String, Object> fieldMap) {
		Product product = retrieveProductById(id);
		if (product != null) {
			try {
				for (Map.Entry<String, Object> fieldEntry : fieldMap.entrySet()) {
					// 通过反射来修改属性，其实set方法就可以
					Field field = Product.class.getDeclaredField(fieldEntry.getKey());
					field.setAccessible(true);
					field.set(product, fieldEntry.getValue());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return product;
	}

	@Override
	public Product deleteProductById(long id) {
		Product targetProduct = null;
		Iterator<Product> productIterator = productList.iterator();
		while (productIterator.hasNext()) {
			Product product = productIterator.next();
			if (product.getId() == id) {
				targetProduct = retrieveProductById(id);
				productIterator.remove();
				break;
			}
		}
		return targetProduct;
	}

}
