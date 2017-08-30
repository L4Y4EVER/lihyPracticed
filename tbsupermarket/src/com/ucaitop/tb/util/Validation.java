package com.ucaitop.tb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	/**
	 * 判断电话号是否符合规则的方法
	 */
	public static boolean isTelephone(String tele){
		//利用正则表达式声明规则
		//验证是否是正确的手机号 中国大陆的手机号第一位是1第二位基本上是34587，\d{9}表示后面可以出现0-9任意数字或多个数字
		String reg_telephone ="^1[34587]\\d{9}$";
		//创建获取正则表达式的对象
		Pattern p = Pattern.compile(reg_telephone);
		//创建根据正则表达式进行判断的方法
		Matcher m = p.matcher(tele);
		//返回判断的结果
		return m.matches();	
	}
	/**
	 * 判断密码是否符合规则的方法
	 */
	public static boolean isPassword(String pass){
		//声明正则表达式
		//验证密码的格式 \w=匹配任何字类字符，包括下划线后面的这些就是表示这些字符
		String reg_psw = "^[\\w-`=\\\\\\[\\];',./~!@#$%^&*()_+|{}:\">?]{6,}$";
		//创建绑定正则的对象
		Pattern p = Pattern.compile(reg_psw);
		//创建判断的对象
		Matcher m = p.matcher(pass);
		//返回判断结果
		return m.matches();	
	}
		
}
