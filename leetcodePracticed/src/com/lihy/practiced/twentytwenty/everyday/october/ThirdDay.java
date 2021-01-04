package com.lihy.practiced.twentytwenty.everyday.october;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 每日一题
 *
 * @author superl
 * @date 2020/10/03
 */
public class ThirdDay {

    /**
     * 两数之和
     * 从数组中找到两个数相等的和
     *
     * @param nums nums
     * @param target 目标值
     * @return 结果
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    /**
     * 使用计数方法实现两数之和
     *
     * @param nums shuz
     * @param target 目标
     * @return 结果
     */
    public int[] twoSumCount(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++){
           if (map.containsKey(target - nums[i])){
               return new int[]{i,map.get(target-nums[i])};
           }
           map.put(nums[i],i);
        }
        return null;
    }


}
