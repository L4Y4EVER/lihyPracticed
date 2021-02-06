package com.lihy.practiced.twentytwentyone;

/**
 * @author lhy
 * @date 2021/2/6
 */
public class FebruaryPracticed {


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
