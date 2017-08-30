package com.ucaitop.tb.userService;

import java.util.List;

import com.ucaitop.tb.domain.ProOrder;
import com.ucaitop.tb.domain.User;

/**
 * 关于订单的服务层接口
 * @author AZTQ
 *
 */
public interface ProOrderService {
	/**
	 * 添加订单
	 */
	void addProOrder(ProOrder proOrder);
	/**
	 * 获取全部订单
	 */
	List<ProOrder> getAllProOrder(User user);
	/**
	 * 删除订单
	 * 或者直接传递订单的id
	 */
	boolean removeProOrder(ProOrder proOrder);
}
