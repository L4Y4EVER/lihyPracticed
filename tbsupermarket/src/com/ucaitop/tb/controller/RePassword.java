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


@WebServlet("/RePassword")
public class RePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public RePassword() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置得到请求的编码
		request.setCharacterEncoding("utf-8");
		//设置响应的编码
		response.setContentType("text/html:charset=utf-8");
		//获取传递的参数
		String tele = request.getParameter("user_tele");
		String pass = request.getParameter("user_pass_word");
		
		//判断输入的格式
		if(Validation.isTelephone(tele)){
			if(Validation.isPassword(pass)){
				//创建服务层对象
				UserService us = new UserServiceImpl();
				//判断是否修改成功，成功返回跳转的信息，失败返回失败的信息
				if(us.changePsw(tele, pass)){
					//返回成功的信息
				}else{
					//返回失败的信息
				}
			}else{
				//返回密码格式不正确
			}
		}else{
			//返回电话号格式不正确
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
