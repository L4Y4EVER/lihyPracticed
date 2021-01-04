package com.lihy.practiced.twentytwenty;

public class RecursionSum {

    public static  int sum(int[] arr){
        return sum(arr,0);
    }

    private static int sum(int[] arr, int left){
        if (left == arr.length){
            return 0;
        }
        return arr[left] + sum(arr,left+1);
    }

    public static void main(String[] args) {
        int[] arr = {1,2,2,3};
        System.out.println(sum(arr));
    }
}
