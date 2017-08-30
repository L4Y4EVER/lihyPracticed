package com.ucaitop.tb.domain;

import java.util.Date;

public class User {
	//属性私有化
	private String id;//id需要做一个uuid的随机id或者是自增
	private String telephone;//让用户名直接等同于电话号，现在属于简单的登陆注册 
	private String password;//用户的密码，选择是否用md5加密
	private int state;//用数字0或者1来判断用户是否完成注册
	
	//属性私有化，提供对应属性的setget方法
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	//重写tosString方法，方便测试返回的对象
	@Override
	public String toString() {
		return "User [id=" + id + ", telephone=" + telephone + ", password=" + password + ", state=" + state + "]";
	}
	
	
	
}
