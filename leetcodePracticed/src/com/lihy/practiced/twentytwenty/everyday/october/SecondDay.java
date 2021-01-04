package com.lihy.practiced.twentytwenty.everyday.october;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 2020 10月第2天
 *
 * @author superl
 * @date 2020/10/02
 */
public class SecondDay {
    /**
     * leetcode 771号题宝石与石头
     *
     * @param J 宝石字符
     * @param S 自己拥有石头字符
     * @return 结果
     */
    public int numJewelsInStones(String J, String S) {
        int jewelsCount = 0;
        Set<Character> jewelsSet = new HashSet<Character>();
        int jewelsLength = J.length(), stonesLength = S.length();
        for (int i = 0; i < jewelsLength; i++) {
            char jewel = J.charAt(i);
            jewelsSet.add(jewel);
        }
        for (int i = 0; i < stonesLength; i++) {
            char stone = S.charAt(i);
            if (jewelsSet.contains(stone)) {
                jewelsCount++;
            }
        }
        return jewelsCount;
    }
}
