package com.ucaitop.tb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ucaitop.tb.sercice.impl.UserServiceImpl;
import com.ucaitop.tb.userService.UserService;
import com.ucaitop.tb.util.Validation;

/**
 * 判断登陆的servlet
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置请求的编码格式
		request.setCharacterEncoding("utf-8");
		//设置相应的编码格式
		response.setContentType("text/html:charset=utf-8");
		//获取参数
		String tele = request.getParameter("user_phone");
		String pass = request.getParameter("user_pass_word");
		//判断用户名密码格式是否正确
		if(Validation.isTelephone(tele)){
			if(Validation.isPassword(pass)){
				//创建服务层对象
				UserService us = new UserServiceImpl();
				//调用验证登陆的方法
				if(us.findUser(tele, pass)){
					//找到匹配对象证明登陆成功返回一个值
				}else{
					//返回用户名密码错误
				}
			}else{
				//返回密码格式不正确
			}
		}else{
			//账户格式不正确
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
