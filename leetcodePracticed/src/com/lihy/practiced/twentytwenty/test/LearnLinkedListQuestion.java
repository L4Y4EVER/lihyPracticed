package com.lihy.practiced.twentytwenty.test;


import com.lihy.practiced.bean.ListNode;

/**
 * 反转链表 从 m - n
 *
 * @author lihongyan
 * @date 2020/8/28
 */
public class LearnLinkedListQuestion {

	private boolean stop;
	private ListNode left;

	private void recurseAndReverse(ListNode right, int m, int n) {

		if (n == 1) {
			return;
		}

		right = right.next;

		if (m > 1) {
			this.left = this.left.next;
		}

		this.recurseAndReverse(right, m - 1, n - 1);
		if (this.left == right || right.next == this.left) {
			this.stop = true;
		}

		if (!this.stop) {
			int t = this.left.val;
			this.left.val = right.val;
			right.val = t;
			this.left = this.left.next;
		}
	}


	public ListNode reverseBetween(ListNode head, int m, int n){
		this.left = head;
		this.stop = false;
		this.recurseAndReverse(head, m, n);
		return head;
	}
	public static void main(String[] args){
		ListNode root = new ListNode(0);
		ListNode curNode = root;
		for (int i = 1; i < 10; i++) {
			curNode.next = new ListNode(i);
			curNode = curNode.next;
		}

		sout(root);
		System.out.println();
		LearnLinkedListQuestion learnLinkedListQuestion = new LearnLinkedListQuestion();
		ListNode listNode = learnLinkedListQuestion.reverseBetween(root, 3, 8);
		sout(listNode);

	}

	private static void sout(ListNode root){
		if (root == null){
			return;
		}
		System.out.print(root.val+",");
		sout(root.next);
	}


	public ListNode reverseList(ListNode node){
		if (node == null || node.next == null){
			return node;
		}

		ListNode listNode = reverseList(node.next);
		node.next.next = node;
		node.next = null;

		return listNode;
	}

	public ListNode reverse(ListNode node){
		if (node == null){
			return node;
		}
		ListNode nextNode = node.next;
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = node;
		ListNode curNode = node;
		while (curNode != null){
			dummyHead.next = nextNode;
			curNode.next = null;
			curNode = nextNode.next ;
			nextNode = nextNode.next;

		}

		return dummyHead.next;
	}

}
