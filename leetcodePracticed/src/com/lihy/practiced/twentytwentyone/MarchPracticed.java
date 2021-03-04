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
    
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        
        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    return e1[0] - e2[0];
                } else {
                    return e2[1] - e1[1];
                }
            }
        });

        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
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
