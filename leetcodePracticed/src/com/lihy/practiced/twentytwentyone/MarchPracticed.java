package com.lihy.practiced.twentytwentyone;

import java.util.*;

import com.lihy.practiced.bean.ListNode;

/**
 * 三月算法练习
 *
 * @author lhy
 * @date 2021/3/3
 */
public class MarchPracticed {
    MarchPracticed(){

    }

    public static void main(String[] args) {
//        MarchPracticed marchPracticed = new MarchPracticed();
//        marchPracticed.countBits(2);
    }


    /**
     * 反转从left  到 right 之间的
     *
     * @param head head
     * @param left left
     * @param right right
     * @return 返回反转后的链表
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 判断为null 的及 一个节点的链表
        if (head == null || head.next == null || left >= right){
            return head;
        }





        return head;
    }

    /**
     *
     * 基本锁定记忆 搜索和动态规划，但是学艺不经 竟不去锻炼
     * 不同的子序列
     *
     * @param s 主要字符串
     * @param t 目标子串
     * @return 结果
     */
    public int numDistinct(String s,String t){
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 给定一个n  获取其平方个数的螺旋矩阵
     *
     * @param n n
     * @return 矩阵
     */
    public int[][] generateMatrix(int n) {
        if (n == 0){
            return null;
        }
        if (n == 1){
            return new int[][]{{1}};
        }

        int count = n * n;
        int[][] matrix = new int[n][n];
        boolean[][] added = new boolean[n][n];
        int[][] steps = {{0,1},{1,0},{0,-1},{-1,0}};
        int row = 0,column = 0,step = 0;

        for (int i = 1; i <= count; i++ ){
            matrix[row][column] = i;
            added[row][column] = true;

            int nextRow = row + steps[step][0];
            int nextColumn = column + steps[step][1];
            boolean flag = nextRow <= 0 || nextRow >= n
                    || nextColumn <= 0 || nextColumn >= n
                    || added[nextRow][nextColumn];

            if (flag){
                step = (step + 1) % 4;
            }

            row += steps[step][0];
            column += steps[step][1];
        }

        return matrix;
    }


    /**
     * 螺旋遍历一个二维矩阵
     *
     * @param matrix 矩阵
     * @return 结果
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        // 创建一个看过记录
        boolean[][] visited = new boolean[rows][columns];
        int total = rows * columns;
        int row = 0, column = 0;
        // 根据这个数组，确定该点所在row 的动作
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            // 计算 下一个点位的坐标
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            // 分别判断了行的范围，列的范围，以及下一个点是否已经读过了
            boolean flag = nextRow < 0 || nextRow >= rows
                    || nextColumn < 0 || nextColumn >= columns
                    || visited[nextRow][nextColumn];
            if (flag) {
                // 当满足相关的点，需要加进行 行索引的增加 通过取模的运算，获取当前应该取到的行走方式
                directionIndex = (directionIndex + 1) % 4;
            }
            // 修改点位
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }



    /**
     * 判断一个二叉树的前序遍历序列化是否正确
     * 二叉树的前序便利为每次都操作当前节点，然后是左子节点，然后是右子节点
     * 按照这个操作就是，当遇到两个#号的时候，表示该子树终结了
     * 首先明确二叉树的定义，以及前序遍历的定义
     * 当前节点，0，左子节点 0 + 1；左子节点一直到头，就是到一个# 终止了
     *
     * @param preorder 入参
     * @return 是否正确
     */
    public boolean isValidSerialization(String preorder) {
        if ("".equals(preorder) || preorder.length() == 0){
            return true;
        }

        // 根据 , 分割字符串
        String[] split = preorder.split(",");
        Deque<Integer> deque = new LinkedList<>();
        deque.push(1);

        int num = 0;
        while (num < split.length ){
            if (deque.isEmpty()){
                return false;
            }
            String str = split[num];
            // 如果当前元素为# 则进行以下判断
            if ("#".equals(str)){
                // 遇到空值消耗一个槽
                int top = deque.pop() - 1;
                if (top > 0){
                    deque.push(top);
                }
                num ++;
            }else { // 遇到非空节点，消耗一个槽，并补充两个槽
                int top = deque.pop() - 1;
                if (top > 0) {
                    deque.push(top);
                }
                deque.push(2);
                num++;
            }
        }

        return deque.isEmpty();
    }

    int[][] sums;

    public MarchPracticed(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i][j + 1] = sums[i][j] + matrix[i][j];
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }

    /**
     * 基本计算器
     *
     * @param s 入参
     * @return 结果
     */
    public int calculateOne(String s) {
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }


    /**
     * 基本计算器||
     *
     * @param s 入参
     * @return 结果
     */
    public int calculate(String s) {
        if ("".equals(s) || s.length() == 0){
            return 0;
        }
        // 顺序接入
        int[] nums = new int[s.length()];
        LinkedHashMap<Character,Integer> hashMap = new LinkedHashMap<>();


        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if ( c == '+' || c == '-' || c == '*' || c == '/' ){

            }
        }


        return 0;
    }

    /**
     * 删除重复字符
     *
     * @param str s
     * @return 删除后的字符串
     */
    public String removeDuplicates(String str) {

        if("".equals(str) || str.length() == 0){
            return "";
        }
        StringBuilder stack = new StringBuilder();
        int top = -1;

        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }

        return stack.toString();
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
     * @param nums 入参
     * @return 结果
     */
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ret = new int[n];
        Arrays.fill(ret, -1);
        Deque<Integer> stack = new LinkedList<Integer>();
        int cap = 2;
        for (int i = 0; i < n * cap - 1; i++) {
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
            int pop = que.pop();

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

            int peek = que.peek();

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

/**
 * 3-13 题
 */
class MyHashSet {

    private Map<Integer,Object> hashSet;


    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new HashMap<>();
    }

    public void add(int key) {
        hashSet.put(key,null);
    }

    public void remove(int key) {
        hashSet.remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashSet.containsKey(key);
    }
}
class MyHashMap {

    private Node[] table;

    private int capacity = 43;

    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new Node[capacity];
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % capacity;
        Node node = new Node(key, value);
        Node curNode = table[index];
        if (curNode == null){
            table[index] = node;
        }else {
            if (key != curNode.key){
                if (curNode.next == null){
                    curNode.next = node;
                }else {
                    Node perNode = curNode;
                    Node next = curNode.next;

                    while (next != null){
                        perNode = perNode.next;
                        next = next.next;
                    }
                    perNode.next = node;
                }

            }else {
                curNode.value = value;
            }
        }
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % capacity;
        Node curNode = table[index];
        if (curNode == null){
            return -1;
        }else {
            if (curNode.key == key){
                return curNode.value;
            }else {
                Node cur = curNode;
                while (cur != null){
                    if (cur.key == key){
                        return cur.value;
                    }
                    cur = cur.next;
                }
                return -1;
            }
        }

    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % capacity;
        Node curNode = table[index];
        if (curNode != null){
            if (curNode.next == null){
                table[index] = null;
            }else {
                // 删除链表的节点
                Node dummy = new Node();
                dummy.next = curNode;
                Node perNode = dummy;
                Node cur = curNode;

                while (cur != null){

                    Node next = cur.next;
                    if (cur.key == key){
                        perNode.next = next;
                        cur.next = null;
                        break;
                    }
                    perNode = cur;
                    cur = next;

                }

                table[index] = dummy.next;

            }
        }
    }

    public static class Node{
        public int key;
        public int value;

        public Node next;

        public Node(){
        }

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
}

class MyHashMapLeet {
    private class Pair {
        private int key;
        private int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    private static final int BASE = 769;
    private LinkedList[] data;

    /** Initialize your data structure here. */
    public MyHashMapLeet() {
        data = new LinkedList[BASE];
        for (int i = 0; i < BASE; ++i) {
            data[i] = new LinkedList<Pair>();
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                pair.setValue(value);
                return;
            }
        }
        data[h].offerLast(new Pair(key, value));
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.getKey() == key) {
                return pair.value;
            }
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int h = hash(key);
        Iterator<Pair> iterator = data[h].iterator();
        while (iterator.hasNext()) {
            Pair pair = iterator.next();
            if (pair.key == key) {
                data[h].remove(pair);
                return;
            }
        }
    }

    private static int hash(int key) {
        return key % BASE;
    }
}

class ParkingSystem {

    private int[] carParking;

    public ParkingSystem(int big, int medium, int small) {
        carParking = new int[4];
        carParking[1] = big;
        carParking[2] = medium;
        carParking[3] = small;

    }

    public boolean addCar(int carType) {
        int num = carParking[carType];
        if ( num != 0){
            carParking[carType]--;
            return true;
        }
        return false;
    }
}