package com.lihy.practiced.twentytwenty.everyday.october;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author lhy
 * @date 2020/10/28
 */
public class TwentyEighthDay {

        public boolean uniqueOccurrences(int[] arr) {
            if (arr.length == 0){
                return true;
            }
            Map<Integer,Integer> countMap = new HashMap<>();
            for (int a:arr){
                if (countMap.containsKey(a)){
                    countMap.put(a,countMap.get(a) + 1);
                }else {
                    countMap.put(a,1);
                }
            }
            Set<Integer> set = new HashSet<>();
            for (Integer  value : countMap.values()) {
                if (!set.add(value)){
                    return false;
                }
            }
            return true;
        }
}
