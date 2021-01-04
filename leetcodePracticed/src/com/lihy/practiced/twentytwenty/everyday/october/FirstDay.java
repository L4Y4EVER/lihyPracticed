package com.lihy.practiced.twentytwenty.everyday.october;

/**
 * leetcode每日一题详解
 *
 * @author lihy
 * @date 2020/10/01
 */
public class FirstDay {

    /**
     * 收集树叶
     * 这题挺难啊，难到我了
     *
     * @param leaves 树叶数组
     * @return 结果
     */
    public int minimumOperations(String leaves) {
        // 这是一个字符 数组
        char[] chars = leaves.toCharArray();
        int head = 0;
        int tail = chars.length - 1;
        while (head <= tail){
            while (chars[head] == 'r'){
                head++;
            }
            while (chars[tail] == 'r'){
                tail--;
            }


        }

        return 0;
    }
}
