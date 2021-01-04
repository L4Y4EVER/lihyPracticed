package com.lihy.practiced.twentytwenty.everyday.october;

/**
 * @author lihongyan
 * @date 2020/10/9
 */
public class EighthDay {
	public void reverseString(char[] s) {
		int l = 0;
		int r = s.length - 1;

		while (l < r){
			char c = s[l];
			s[l++] = s[r];
			s[r--] = c;

		}
	}


}
