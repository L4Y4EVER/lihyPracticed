package com.lihy.practiced.interview;

/**
 * @author lhy
 * @date 2021/2/2
 */
public class ArrayPractice {

    public static void main(String[] args) {
        ArrayPractice arrayPractice = new ArrayPractice();
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {4,5,6};
        arrayPractice.merge(nums1,3,nums2,3);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arrays = new int[m];
        System.arraycopy(arrays,0,nums1,0,m);

        int p = 0;
        int p1 = 0;
        int p2 = 0;

        while (p1 < m && p2 <n){
            if (arrays[p1] < nums2[p2]){
                nums1[p++] = arrays[p1++];
            }else if (arrays[p1] > nums2[p2]){
                nums1[p++] = nums2[p2++];
            }else {
                nums1[p++] = arrays[p1++];
                nums1[p++] = nums2[p2++];
            }
        }

        if (p1 < m){
            System.arraycopy(nums1,p1 + n, arrays,p1,m);
        }

        if (p2 < n){
            System.arraycopy(nums1,p2 + m, nums2,p2,n);
        }
    }
}
