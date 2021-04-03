package com.lihy.practiced.twentytwentyone;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 四月每日一题
 *
 * @author hongyanli
 * @since 2021/4/1 11:10
 */
public class AprilPracticed {

    public static void main(String[] args) {
        System.out.println(clumsy(10));;
    }


    /**
     * 03
     *
     * @param text1 串1
     * @param text2 串2
     * @return 结果
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 01 问题， 笨阶乘
     *
     * @param N 入参
     * @return 结果
     */
    public static  int clumsy(int N) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(N--);


        int i = 0;
        while (N > 0){
           if (i % 4 == 0){
               stack.push(stack.pop() * N);
           }else if (i % 4 == 1){
               stack.push(stack.pop() / N);
           }else if (i % 4 == 2){
               stack.push(N);
           }else {
               stack.push(-N);
           }
           N--;
           i++;
        }

        int result = 0;
        while (!stack.isEmpty()){
            result += stack.pop();
        }
        return result;
    }
}
