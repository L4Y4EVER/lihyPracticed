package com.ucaitop.tb.userDao;

import java.util.List;

import com.ucaitop.tb.domain.Product;

/**
 * 商品持久层接口
 * @author AZTQ
 *
 */
public interface ProductDao {
	/**
	 * 得到对应种类的商品
	 */
	List<Product> selectProductByCategory(String category);
	
	/**
	 * 查找对应商品的基本信息信息
	 */
	Product selectProduct(String productId);
	
	/**
	 * 查找对应商品的全部信息
	 */
	Product selectProductAll(String productId);
}
