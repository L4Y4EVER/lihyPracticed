package com.lihy.practiced.twentytwenty.everyday.october;

/**
 * @author lihongyan
 * @date 2020/10/9
 */
public class SevenThDay {

	public void sortColors(int[] nums) {
		if (nums.length == 0){
			return;
		}

		int left = 0;
		int i = 0;
		int r = nums.length - 1;

		while (i <= r){
			if (nums[i] < 1){
				swap(nums,i,left);
				left ++;
				i++;
			}else if (nums[i] > 1){
				swap(nums,i,r);
				r--;
			}else {
				i++;
			}
		}

	}

	private void swap(int[] nums, int size, int i) {
		int num = nums[i];
		nums[i] = nums[size];
		nums[size] = num;
	}
}
