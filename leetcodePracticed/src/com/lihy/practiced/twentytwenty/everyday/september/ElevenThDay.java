package com.lihy.practiced.twentytwenty.everyday.september;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihongyan
 * @date 2020/9/11
 */
public class ElevenThDay {
	List<Integer> temp = new ArrayList<Integer>();
	List<List<Integer>> ans = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		for (int mask = 0; mask < (1 << 9); ++mask) {
			if (check(mask, k, n)) {
				ans.add(new ArrayList<Integer>(temp));
			}
		}
		return ans;
	}

	public boolean check(int mask, int k, int n) {
		temp.clear();
		for (int i = 0; i < 9; ++i) {
			if (((1 << i) & mask) != 0) {
				temp.add(i + 1);
			}
		}
		if (temp.size() != k) {
			return false;
		}
		int sum = 0;
		for (int num : temp) {
			sum += num;
		}
		return sum == n;
	}
}
