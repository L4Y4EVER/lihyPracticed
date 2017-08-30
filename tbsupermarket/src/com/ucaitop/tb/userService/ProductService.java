package com.ucaitop.tb.userService;

import java.util.List;

import com.ucaitop.tb.domain.Product;

/**
 * 关于商品的接口
 * @author AZTQ
 * 
 */
public interface ProductService {
	/**
	 * 得到对应种类的商品
	 */
	List<Product> findProductByCategory(String category);
	
	/**
	 * 查找对应商品的基本信息信息
	 */
	Product findProduct(String productId);
	
	/**
	 * 查找对应商品的全部信息
	 */
	Product findProductAll(String productId);
}
