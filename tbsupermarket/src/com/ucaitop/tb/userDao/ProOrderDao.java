package com.ucaitop.tb.userDao;

import java.util.List;

import com.ucaitop.tb.domain.ProOrder;
import com.ucaitop.tb.domain.User;

/**
 * 关于订单的持久层接口
 * @author AZTQ
 *
 */
public interface ProOrderDao {
	
	/**
	 * 添加订单
	 */
	void insertProOrder(ProOrder proOrder);
	
	/**
	 * 获取全部订单
	 */
	List<ProOrder> selectAllProOrder(User user);
	
	/**
	 * 删除订单
	 * 或者直接传递订单的id
	 */
	boolean delProOrder(ProOrder proOrder);
}
