package com.lihy.practiced.twentytwentyone;

import java.util.*;

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

    boolean[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;


    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (f[i][j]) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    /**
     * 分割回文串
     *
     * @param s s
     * @return 回文串
     */
    public List<List<String>> partition(String s) {
        n = s.length();
        f = new boolean[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], true);
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                f[i][j] = (s.charAt(i) == s.charAt(j)) && f[i + 1][j - 1];
            }
        }

        dfs(s, 0);
        return ret;
    }

    /**
     * 03-06
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n * 2 - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                ret[stack.pop()] = nums[i % n];
            }
            stack.push(i % n);
        }
        return ret;
    }


    /**
     * 03-05
     * 两个栈实现一个队列
     */
    class MyQueue {
        private Deque<Integer> deque;
        private Deque<Integer> que;


        /** Initialize your data structure here. */
        public MyQueue() {
            deque = new LinkedList<>();
            que = new LinkedList<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            deque.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            int size = deque.size();
            while ( size > 0){
                que.push(deque.pop());
                size --;
            }
            Integer pop = que.pop();

            int qSize = que.size();
            while (qSize >0 ){
                deque.push(que.pop());
                qSize --;
            }

            return pop;
        }

        /** Get the front element. */
        public int peek() {
            int size = deque.size();
            while ( size > 0){
                que.push(deque.pop());
                size --;
            }

            Integer peek = que.peek();

            int qSize = que.size();
            while (qSize >0 ){
                deque.push(que.pop());
                qSize --;
            }

            return peek;
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return deque.isEmpty() && que.isEmpty();
        }
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        
        int n = envelopes.length;
        Arrays.sort(envelopes, (e1, e2) -> {
            if (e1[0] != e2[0]) {
                return e1[0] - e2[0];
            } else {
                return e2[1] - e1[1];
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
