package com.lihy.practiced.twentytwenty.test;

import java.util.TreeMap;

/**
 * leetcode 677
 * 实现一个 MapSum 类里的两个方法，insert和sum。
 *
 * 对于方法insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 *
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 *
 *
 * @author lihongyan
 * @date 2020/9/12
 */
public class MapSum {

	private class Node{
		private int value;
		private TreeMap<Character,Node> next;

		public Node(int value){
			this.value = value;
			this.next = new TreeMap<>();
		}
		public Node(){
			this(0);
		}
	}

	private Node root;

	/** Initialize your data structure here. */
	public MapSum() {
		this.root = new Node();
	}

	public void insert(String key, int val) {
		Node cur = root;
		for (int i =0; i<key.length();i++){
			char c = key.charAt(i);
			if (cur.next.get(c) == null){
				cur.next.put(c,new Node());
			}
			cur = cur.next.get(c);
		}
		cur.value = val;
	}

	public int sum(String prefix) {
		Node cur = root;
		for (int i =0; i<prefix.length();i++){
			char c = prefix.charAt(i);
			if (cur.next.get(c) == null){
				return 0;
			}
			cur = cur.next.get(c);
		}
		return sumVal(cur);
	}

	private int sumVal(Node cur) {

		int sum = cur.value;
		for (char c : cur.next.keySet()){
			sum += sumVal(cur.next.get(c));
		}
		return sum;
	}
}
