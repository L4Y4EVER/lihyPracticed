package com.lihy.practiced.twentytwentyone;

/**
 * 三月算法练习
 *
 * @author lhy
 * @date 2021/3/3
 */
public class MarchPracticed {


    public static void main(String[] args) {
        MarchPracticed marchPracticed = new MarchPracticed();
        marchPracticed.countBits(2);
    }

    public int[] countBits(int num) {

        int[] memo = new int[num + 1];
        for (int i = num; num >0; i--){
            String s = intToBinary(i);
            int count = 0;
            for (int j = 0;j < s.length(); j++){
                if (s.charAt(j) == '1'){
                    count++;
                }
            }
            memo[i] = count;
        }

        return memo;
    }



    public String intToBinary(int n){
        String  str = "";
        while(n!=0) {
            str = n % 2 + str;
            n = n / 2;
        }
        return str;
    }
}
