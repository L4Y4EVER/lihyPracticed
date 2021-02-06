package com.lihy.practiced.twentytwentyone;

/**
 * @author lhy
 * @date 2021/2/6
 */
public class FebruaryPracticed {


    public int knapsack01DP(int[] w,int[] v,int c){
        int n = w.length;
        int p = v.length;
        if (n != p){
            return 0;
        }
        if (n == 0){
            return n;
        }
        memoSpace = new int[n][c+1];

        for (int j = 0;j <=c; j++){
            memoSpace[0][j] = (j >= w[0]? v[0] : 0);
        }


        for (int i= 1; 1< n; i++){
            for (int j=0;j<=c;j++){
                memoSpace[i][j] = memoSpace[i-1][j];
                if (j >= w[i]){
                    memoSpace[i][j] = Math.max(memoSpace[i][j],v[i] + memoSpace[i-1][j-w[i]]);
                }
            }
        }

        return memoSpace[n-1][c];
    }


    int[][] memoSpace;

    public int knapsack01(int[] w,int[] v,int c){
        int n = w.length;
        memoSpace = new int[n][c+1];
        return bestValue(w,v,n-1,c);
    }

    private int bestValue(int[] w, int[] v, int index, int c) {
        if (index < 0|| c <= 0){
            return 0;
        }

        if (memoSpace[index][c] != 0){
            return memoSpace[index][c];
        }
        int res = bestValue(w,v,index -1,c);
        if (c >= w[index]){
            res = Math.max(res,v[index] + bestValue(w,v,index - 1,c-w[index]));
        }
        memoSpace[index][c] = res;

        return res;
    }


    public int robDP(int[] nums){
        int n = nums.length;
        if (n == 0 ){
            return 0;
        }
        int[] memos = new int[n];

        memos[n-1] = nums[n-1];
        for (int i = n-2; i >=0 ; i--){
            for (int j = i; j < n; j++){
                memos[i] = Math.max(memos[i],nums[j] + (j+2 < n ?nums[j+2]:0));
            }
        }


        return memos[0];
    }


    // 问题的状态是什么，状态转移是什么？

    public int rob(int[] nums){
        memo = new int[nums.length + 1];
        return tryRob(nums,0);
    }


    private int tryRob(int[] nums, int index) {
        if (index >= nums.length){
            return 0;
        }
        if (memo[index] != 0)
            return memo[index];

        int res = 0;
        for (int i = index; i < nums.length; i++ ){
            res = Math.max(res ,nums[i] + tryRob(nums,i+2));
        }
        memo[index] = res;

        return res;
    }


    private int[] memo;

    /**
     * leetcode 343 integer Break 问题
     *
     *
     * 最优子结构
     *
     * @param n 正整数n
     * @return 乘积最大的结果
     */
    public int integerBreak(int n){
        if ( n < 2){
           return n;
        }
        memo = new int[n+1];
        return breakInteger(n);
    }

    private int breakInteger(int n) {
        if (n == 1){
            return 1;
        }
        if (memo[n] != 0){
            return memo[n];
        }
        int result = -1;

        for (int i = 1; i <= n - 1; i++ ){
            result = Math.max(result,Math.max(i * (n - 1),i * breakInteger(n - 1)));
        }
        memo[n] =result;
        return result;
    }


    public int integerBreakDN(int n){
        if ( n < 2){
            return n;
        }
        int[] memoDN = new int[n+1];
        memoDN[1] = 1;
        for (int i = 2; i <= n ; i++){
            for (int j = 1; j<= i -1; j++){
                memoDN[i] = Math.max(memoDN[i],Math.max(j*(i-j),j*memoDN[i-j]));
            }
        }
        return memoDN[n];

    }
}
