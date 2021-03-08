package com.lihy.practiced.twentytwentyone.interview;

/**
 * @author hongyanli
 * @since 2021/3/8 15:45
 */
public class ArrayPracticed {


    public static void main(String[] args) {
        int size = 10000000;
        int[] nums = new int[size];

        for (int i = 0; i < size; i++){
            nums[i] = i;
        }

        System.out.println(binarySearch(nums,10));
    }


    /**
     * 对有序数组进行二分查找。
     * 这里面如果中位数计算在循环过程中反复生成并赋值会比循环外声明一个变量多占用一点儿内存
     *
     * @param nums 目标数组
     * @param k 目标数字在数组中下标
     * @return 返回结果
     */
    public static int binarySearch(int[] nums,int k){
        if (nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left <= right){
            mid = left + (right - left) / 2;
            if (nums[mid] == k){
                return mid;
            }else if (nums[mid] < k){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
