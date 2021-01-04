package com.lihy.practiced.twentytwenty.everyday.october;

import java.util.Arrays;

/**
 *
 * 第16日题
 */
public class SixteenthDay {

    public int[] sortedSquares(int[] A) {
        int[] results = new int[A.length];
        for (int i = 0; i < A.length; i++){
            results[i] = A[i] * A[i];
        }
        Arrays.sort(results);
        return results;
    }
}
