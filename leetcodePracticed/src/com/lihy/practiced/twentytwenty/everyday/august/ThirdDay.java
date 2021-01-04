package com.lihy.practiced.twentytwenty.everyday.august;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 *
 * @author lihongyan
 * @date 2020/8/3
 */
public class ThirdDay {

	public static void main(String[] args){
	    String num = "123";
		String num1 = "321";
		System.out.println(addStrings(num,num1));
	}

	public static String addStrings(String num1, String num2) {
		int i = num1.length() - 1, j = num2.length() - 1, add = 0;
		StringBuffer ans = new StringBuffer();
		while (i >= 0 || j >= 0 || add != 0) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int result = x + y + add;
			ans.append(result % 10);
			add = result / 10;
			i--;
			j--;
		}
		// 计算完以后的答案需要翻转过来
		ans.reverse();
		return ans.toString();
	}
}
