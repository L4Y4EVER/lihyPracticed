package com.lihy.practiced.twentytwenty.everyday.august;

/**
 * 重复的子字符串
 *
 * @author lihongyan
 * @date 2020/8/24
 */
public class TwentyFourthDay {

	/**
	 * 如果一个长度为 n 的字符串 s 可以由它的一个长度为 n'的子串 s' 重复多次构成，那么
	 * @param s
	 * @return
	 */
	public boolean repeatedSubStringPattern(String s){
		int n = s.length();
		for (int i = 1; i * 2 < n; ++i){
			if (n % i == 0){
				boolean match = true;
				for (int j = i; j < n; ++j){
					if (s.charAt(j) != s.charAt(j-i)){
						match = false;
						break;
					}
				}
				if (match){
					return true;
				}
			}

		}

		return false;
	}
	public boolean repeatedSubstringPattern(String s) {
		return (s + s).indexOf(s, 1) != s.length();
	}
	
	public static void main(String[] args){
	    String s = "abcabcabcabc";
		String s1 = "abcab";
		TwentyFourthDay twentyFourthDay = new TwentyFourthDay();
		System.out.println(twentyFourthDay.repeatedSubstringPattern(s));
		System.out.println(twentyFourthDay.repeatedSubStringPattern(s));
		System.out.println(twentyFourthDay.repeatedSubstringPattern(s1));
		System.out.println(twentyFourthDay.repeatedSubStringPattern(s1));
	}

}
