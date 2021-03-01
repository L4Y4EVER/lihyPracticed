package com.lihy.practiced.twentytwentyone.interview;

import java.util.Arrays;

/**
 * 贪心算法学习
 *
 * @author lhy
 * @date 2021/2/28
 */
public class GreedPracticed {


    /**
     * 455
     *
     * 贪心指数，饼干大小
     * @param g 贪心指数
     * @param s 饼干大小
     * @return 满足人数
     */
    int findContentChildren(int[] g,int[] s){

        Arrays.sort(g);
        Arrays.sort(s);

        int gi = g.length - 1;
        int si = s.length - 1;
        int res = 0;

        while (gi >= 0 && si >= 0){
            if (g[gi] <= s[si]){
                gi --;
                si --;
                res ++;
            }else {
                gi --;
            }
        }
        return res;
    }

}
