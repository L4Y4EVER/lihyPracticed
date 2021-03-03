package com.lihy.practiced.twentytwentyone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NiuClass {





    /**
     4 5 5
     1 5 5 10
     1 3 8 8 20
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            // 先获取全部的值
            String next = in.nextLine();
            String[] s = next.split(" ");
            int length = s.length;
            int[] ints = new int[length];
            for (int i=0;i < length ; i++ ){
                ints[i] = Integer.parseInt(s[i]);
            }

            Arrays.sort(ints);

            long maxNum = -1;

            for (int i = 0 ; i < length; i ++){
                StringBuilder str = new StringBuilder(ints[i] + "");
                for (int j = 0; j < length; j++){
                    if (j == i){
                        continue;
                    }
                    str.append(ints[j]);
                }
                long max = Long.parseLong(str.toString());
                maxNum = Math.max(max,maxNum);
            }
            System.out.println(maxNum);
        }
    }

    public static void test2(int m,int n, int r,Scanner in){

        // 分别初始化数组的值；
        int[] A = new int[m];
        for (int i = 0; i < m; i++){
            A[i] = in.nextInt();
        }

        int[] B = new int[n];
        for (int i = 0; i< n; i++){
            B[i] = in.nextInt();
        }

        for (int i = 0; i < m; i++){
            // 在B 中找 与A 最近且满足条件的点
            for (int j = 0; j < n ; j++) {

                if (B[j] - A[i] <= r && B[j] >= A[i]){
                    System.out.println(A[i]+" " + B[j]);
                    break;
                }

            }

        }
    }

    private static int findBj(int[] b, int i, int r) {
        // 其实就是在B 中找target 或者比 target 小且大于 i的数；结合B 的有序性进行二分查找
        int length = b.length;
        int left = 0;
        int right = length - 1;

        return findTarget(b,left,right,r,i);
    }

    private static int findTarget(int[] b, int left, int right, int target, int i) {
        if (b[right] < i){
            return 0;
        }
        int mid = right / 2;

        if (b[mid] - i > target){
            return findTarget(b,left,mid -1,target,i);
        } else {
            for (int x = left; x <= mid; x ++ ){
                if (b[x] - i <= target && b[x] -i >=0){
                    return b[x];
                }
            }
            return 0;
        }

    }

    public static void test1(int[] person,int power){

        int a = person.length;
        int pick = 0;

        // 当获取这么多内容后，遍历让两两结对，得到符合能力的结对
        for (int i= 0; i < a; i++){
            for (int j = i+1; j < a; j++){
                if (person[i] + person[j] == power){
                    pick ++;
                }
            }
        }

        System.out.println(pick);
    }

}
