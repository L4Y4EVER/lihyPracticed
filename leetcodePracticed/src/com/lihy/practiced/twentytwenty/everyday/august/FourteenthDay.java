package com.lihy.practiced.twentytwenty.everyday.august;

import java.util.Stack;

/**
 * 处理括号有序性
 *
 * @author lihongyan
 * @date 2020/8/14
 */
public class FourteenthDay {

	public static boolean isvail(String s){
		Stack<Character> characters = new Stack<>();
		for (int i =0;i< s.length(); i++){
			char c = s.charAt(i);
			if ( c == '('  || c == '[' || c == '{'){
				characters.push(c);
			}else {
				if(characters.empty()){
					return false;
				}
				Character pop = characters.pop();
				if (c == ')' && pop != '('){
					return false;
				}
				if (c == ']' && pop != '['){
					return false;
				}
				if (c == '}' && pop != '{'){
					return false;
				}
			}

		}
		return characters.empty();
	}

}
