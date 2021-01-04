package com.lihy.practiced.twentytwenty.everyday.august;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author lihongyan
 * @date 2020/8/10
 */
public class TenthDay {

	public int countBinarySubstrings(String s) {
		int ptr = 0, n = s.length(), last = 0, ans = 0;
		while (ptr < n) {
			char c = s.charAt(ptr);
			int count = 0;
			while (ptr < n && s.charAt(ptr) == c) {
				++ptr;
				++count;
			}
			ans += Math.min(count, last);
			last = count;
		}
		return ans;
	}

	public int countBinarySubstrings1(String s) {
		List<Integer> counts = new ArrayList<Integer>();
		int ptr = 0, n = s.length();
		while (ptr < n) {
			char c = s.charAt(ptr);
			int count = 0;
			while (ptr < n && s.charAt(ptr) == c) {
				++ptr;
				++count;
			}
			counts.add(count);
		}
		int ans = 0;
		for (int i = 1; i < counts.size(); ++i) {
			ans += Math.min(counts.get(i), counts.get(i - 1));
		}
		return ans;
	}
}
