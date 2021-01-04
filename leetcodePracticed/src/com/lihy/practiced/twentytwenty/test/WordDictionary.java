package com.lihy.practiced.twentytwenty.test;

import java.util.TreeMap;

/**
 * leetcode 211 号问题
 * 如果数据结构中有任何与word匹配的字符串，则bool search（word）返回true，否则返回false。 单词可能包含点“。” 点可以与任何字母匹配的地方。
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与word 匹配，则返回 true ；否则，返回 false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *
 * @author lihongyan
 * @date 2020/9/12
 */
public class WordDictionary {

	private class Node{
		private boolean isWord;
		private TreeMap<Character,Node> next;

		public Node(boolean isWord){
			this.isWord = isWord;
			this.next = new TreeMap<>();
		}

		public Node(){
			this(false);
		}
	}

	private Node root;

	/** Initialize your data structure here. */
	public WordDictionary() {
		this.root = new Node(false);
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if (cur.next.get(c) == null){
				cur.next.put(c,new Node(false));
			}
			cur = cur.next.get(c);
		}
		cur.isWord = true;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {

		return match(root,word,0);
	}

	private boolean match(Node node, String word, int i) {
		if (i == word.length()){
			return node.isWord;
		}
		char c = word.charAt(i);
		if ('.' != c){
			if (node.next.get(c) == null){
				return false;
			}else {
				return match(node.next.get(c),word,i +1);
			}
		}else {
			for (char charNext : node.next.keySet()){
				if (match(node.next.get(charNext),word,i+1)){
					return true;
				}
			}
			return false;
		}
	}
}
