package com.lihy.practiced.twentytwenty.test;

import java.util.*;

/**
 * @author lhy
 * @date 2020/10/24
 */
public class LearnRecursionAndRecall {

    /**
     * 实现数字按钮进行字符的匹配 用到的字典
     */
    private  final Map<Character,String> DICT = new HashMap<>();
     {
        DICT.put('0'," ");
        DICT.put('1',"");
        DICT.put('2',"abc");
        DICT.put('3',"def");
        DICT.put('4',"ghi");
        DICT.put('5',"jkl");
        DICT.put('6',"mno");
        DICT.put('7',"pqrs");
        DICT.put('8',"tuv");
        DICT.put('9',"wxyz");
    }

    /**
     * 字符结果集合
     */
    private List<String> words = new ArrayList<>();

    /**
     * leetcode 17号问题
     *
     * @param digits 字符串
     * @return 结果
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return words;
        }
        StringBuilder wordBuilder = new StringBuilder();
        letterCombination(digits,0,wordBuilder);

        return words;
    }

    /**
     * 递归调用的方法
     *
     * @param digits 字符串
     * @param index 索引
     * @param wordBuilder 拼接对象
     */
    private void letterCombination(String digits, int index, StringBuilder wordBuilder) {
        if (digits.length() == index ){
            words.add(wordBuilder.toString());
            return;
        }
        char c = digits.charAt(index);
        String letter = DICT.get(c);

        for (int i = 0; i < letter.length(); i++){
            wordBuilder.append(letter.charAt(i));
            letterCombination(digits,index + 1,wordBuilder);
            wordBuilder.deleteCharAt(index);
        }
    }


    /**
     * 全排列方法结果集
     *
     */
    private List<List<Integer>> intResults = new ArrayList<>();
    /**
     * 处理全排列
     *
     * @param nums 入参
     * @return 结果
     */
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0){
            return intResults;
        }
        List<Integer> intResult = new ArrayList<>();
        for (int num : nums) {
            intResult.add(num);
        }

        permute(nums.length,0,intResult);

        return intResults;
    }

    /**
     * 处理集合拼接
     *
     * @param n 元素个数
     * @param index 结果
     * @param intResult 结果集
     */
    private void permute(int n, int index,
                         List<Integer> intResult) {
        if (n == index){
            intResults.add(new ArrayList<>(intResult));
            return;
        }

        for (int i = index; i < n; i++) {
            Collections.swap(intResult,i,index);
            permute(n,index + 1,intResult);
            Collections.swap(intResult,i,index);
        }

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        LearnRecursionAndRecall learnRecursionAndRecall = new LearnRecursionAndRecall();
        learnRecursionAndRecall.permute(nums);
    }


    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k){
            return intResults;
        }

        List<Integer> integers = new ArrayList<>();
        combine(n,k,1,integers);
        return intResults;
    }

    private void combine(int n, int k, int index, List<Integer> integers) {
        if (index == k){
            intResults.add(new ArrayList<>(integers));
            return;
        }

    }


}
