package com.ucaitop.tb.controller;

import java.io.IOException;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucaitop.tb.domain.User;
import com.ucaitop.tb.sercice.impl.UserServiceImpl;
import com.ucaitop.tb.userService.UserService;
import com.ucaitop.tb.util.UUIDUtil;
import com.ucaitop.tb.util.Validation;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Register() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置获取的请求参数
		request.setCharacterEncoding("utf-8");
		//设置返回数据的参数
		response.setContentType("text/html:charset=utf-8");
		//获取传递的姓名参数
		String tele = request.getParameter("user_phone");
		//获取提交的密码
		String pass = request.getParameter("user_pass_word");
		//调用判断的方法进行判断
		if(Validation.isTelephone(tele)){
			if(Validation.isPassword(pass)){
				//创建一个user对象
				User user = new User();	
				user.setId(UUIDUtil.getUUID());//给此对象的id赋值一个uuid
				user.setTelephone(tele);//将符合的电话传进来
				user.setPassword(pass);//将符合的密码传进来
				user.setState(1);//1表示状态为注册
				UserService us = new UserServiceImpl();
				us.addUser(user);
			}else{
				//这里返回一个密码格式错误的信息
			}
		}else{
			//返回电话的格式错误
		}
		
	}
	

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
