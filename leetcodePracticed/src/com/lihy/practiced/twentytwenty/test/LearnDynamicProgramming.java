package com.lihy.practiced.twentytwenty.test;

import java.util.Arrays;

/**
 * 学习动态规划相关代码
 * method 1:斐波那契数
 *
 * @author lhy
 * @date 2020/10/25
 */
public class LearnDynamicProgramming {


    /**
     * 斐波那契数列第n项结果 纯递归解法
     *
     * @param n n项
     * @return 结果
     */
    public int fib1(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }

        return fib1(n - 1) + fib1(n - 2);
    }


    public int fib(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return getFibonacciToRecursion(n,memo);
    }
    /**
     * 记忆化搜索的方式-》跟应用缓存好像。
     *
     * @param n 计算n的斐波那契数
     * @return 结果
     */
    private int getFibonacciToRecursion(int n,int[] memo){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (memo[n] == -1){
            memo[n] = getFibonacciToRecursion(n - 1,memo) + getFibonacciToRecursion(n - 2,memo);
        }
        return memo[n];
    }


    /**
     * 动态规划版本获取斐波那契数列第n项结果
     *
     * @param n n
     * @return 结果
     */
    public int getFibonacciToDynamic(int n){
        int[] memo = new int[n+2];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2;i <= n; i++){
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public int getFibonacciToDynamicLeetcode(int n) {
        if (n < 2) {
            return n;
        }
        int p = 0, q = 0, r = 1;
        for (int i = 2; i <= n; ++i) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }




}
