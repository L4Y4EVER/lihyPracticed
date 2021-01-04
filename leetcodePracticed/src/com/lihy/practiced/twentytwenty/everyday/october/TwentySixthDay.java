package com.lihy.practiced.twentytwenty.everyday.october;

/**
 * @author lihongyan
 * @date 2020/10/26
 */
public class TwentySixthDay {

	public int[] smallerNumbersThanCurrent(int[] nums) {
		if (nums.length == 0){
			return null;
		}
		int[] numsCopy = new int[nums.length];

		for (int i = 0; i < nums.length; i++){
			for (int j = 0;j < nums.length; j++){
				if (nums[i] > nums[j]){
					numsCopy[i] = numsCopy[i] + 1;
				}
			}
		}
		return numsCopy;
	}
}
