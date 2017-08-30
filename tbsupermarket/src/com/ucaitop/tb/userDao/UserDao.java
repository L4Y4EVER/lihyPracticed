package com.ucaitop.tb.userDao;

import com.ucaitop.tb.domain.User;

public interface UserDao {
	
	/**
	 * 向数据库中插入用户数据
	 */
	void insertUser(User user);
	
	/**
	 * 从数据库中查找对象
	 */
	User selectUser(String tele,String pass);
	
	/**
	 * 根据要求修改数据库信息
	 */
	boolean updateUser(String tele,String pass);
}
