package com.lihy.practiced.twentytwentyone;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author lhy
 * @date 2021/2/6
 */
public class FebruaryPracticed {


    public static void main(String[] args) {



    }

    public  static void printCharNum(){
        Scanner in = new Scanner(System.in);
        String content  = in.nextLine().toLowerCase();
        String value = in.nextLine().toLowerCase();

//        Map<Character,Integer> map = new HashMap<>(16);
//
        int length = content.length();
//        for (int i = 0; i < length; i++){
//            char c = content.charAt(i);
//            if (map.containsKey(c)){
//                Integer integer = map.get(c);
//                map.put(c,++integer);
//            }else {
//                map.put(c,1);
//            }
//        }

        int num = 0;
        for (int i = 0; i < length; i++){
            if (String.valueOf(content.charAt(i)).equalsIgnoreCase(value)){
                num ++;
            }
        }



        System.out.println(num);


    }


    public static void printLastWordLength(){

        Scanner in = new Scanner(System.in);

        String content  = in.nextLine();;
//        String[] contents = content.split(" ");
//        int size = contents.length;
//        int length = contents[size - 1].length();

        int strL = content.length();
        int length = 0;
        for (int i = strL - 1; i >= 0; i --){
            if (content.charAt(i) == ' '){
                break;
            }
            length ++;
        }


        System.out.println(length);
    }


    /**
     * 376
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int[] memos = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            memos[i] = 1;

        for (int i = 1; i < nums.length; i ++){
            for (int j=0; j < i; j++){
                if (nums[j] < nums[i]){
                    memos[i] = Math.max(memos[i],1+ memos[j]);
                }
            }
        }

        int res = 1;
        for (int i = 0; i< nums.length; i ++ ){
            res = Math.max(res,memos[i]);
        }

        return res;
    }


    /**
     * 将问题转化成背包问题，进行实际解答
     *
     * 322
     * 377
     * 474
     * 139
     * 494
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;

        // 一次循环获取到 集合的和
        for (int num : nums) {
            if (num < 0) {
                return false;
            }
            sum += num;
        }

        // 判断和是否能被2 整除，不能则不能分割
        if (sum % 2 != 0){
            return false;
        }

        int n = nums.length;
        int c = sum / 2;

        boolean[] memos = new boolean[c +1];

        for (int i =0; i<=c;i++){
            memos[i] = (nums[0] == i);
        }

        for (int i =1; i< n; i++){
            for (int j = c; j>= nums[i]; j--){
                memos[j] = memos[j] || memos[j - nums[i]];
            }
        }

        return memos[c];


    }


    /**
     *
     *
     * @param nums
     * @return
     */
    public boolean canPartitionB(int[] nums) {
        int sum = 0;

        // 一次循环获取到 集合的和
        for (int num : nums) {
            if (num < 0) {
                return false;
            }
            sum += num;
        }

        // 判断和是否能被2 整除，不能则不能分割
        if (sum % 2 != 0){
            return false;
        }
        // 记忆化搜索  0 未计算 1 计算正确 2 计算错误
        memoSpace = new int[nums.length][sum/2 +1];
        return tryPartition(nums,nums.length - 1,sum/2);


    }

    private boolean tryPartition(int[] nums, int index, int c) {
        if (c == 0){
            return true;
        }
        if (index < 0 || c < 0){
            return false;
        }

        if (memoSpace[index][c] != 0){
            return memoSpace[index][c] == 1;
        }
        memoSpace[index][c] = tryPartition(nums,index -1,c) || tryPartition(nums,index -1, c-nums[index]) ? 1 : 2;

        return memoSpace[index][c] == 1;
    }


    /**
     * 因为每次考虑前一个数，然后就用一维 搞。
     *
     * @param w
     * @param v
     * @param c
     * @return
     */
    public int knapsack01DPUpPlus(int[] w,int[] v,int c){
        int n = w.length;
        int p = v.length;
        if (n != p){
            return 0;
        }
        if (n == 0){
            return n;
        }
        int[] memo = new int[c+1];

        for (int j = 0;j <=c; j++){
            memo[j] = (j >= w[0]? v[0] : 0);
        }


        for (int i= 1; 1< n; i++){
            for (int j=c;j >= w[i];j--){
                memoSpace[i%2][j] = memoSpace[(i-1)%2][j];
                if (j >= w[i]){
                    memo[j] = Math.max(memo[j],v[i] + memo[j-w[i]]);
                }
            }
        }

        return memo[c];
    }


    /**
     * 因为每次只考虑上一层的 空间，所以只用两层空间就够了，。
     *
     * @param w
     * @param v
     * @param c
     * @return
     */
    public int knapsack01DPUp(int[] w,int[] v,int c){
        int n = w.length;
        int p = v.length;
        if (n != p){
            return 0;
        }
        if (n == 0){
            return n;
        }
        memoSpace = new int[2][c+1];

        for (int j = 0;j <=c; j++){
            memoSpace[0][j] = (j >= w[0]? v[0] : 0);
        }


        for (int i= 1; 1< n; i++){
            for (int j=0;j<=c;j++){
                memoSpace[i%2][j] = memoSpace[(i-1)%2][j];
                if (j >= w[i]){
                    memoSpace[i%2][j] = Math.max(memoSpace[i%2][j],v[i] + memoSpace[(i-1)%2][j-w[i]]);
                }
            }
        }

        return memoSpace[n-1][c];
    }


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
