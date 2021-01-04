package com.lihy.practiced.twentytwenty;

/**
 * @author lihongyan
 * @date 2020/7/24
 */
public class day1_203 {

	public ListNode removeElements1(ListNode head, int val) {

		// 当要删除的内容在链表头
		ListNode dummyHead = new ListNode(-1);
		dummyHead.next = head;

		ListNode prev = dummyHead;
		while(prev.next != null){
			if (prev.next.val == val){
				prev.next = prev.next.next;
			}else {
				prev = prev.next;
			}
		}
		return dummyHead.next;
	}

	public ListNode removeElements(ListNode head, int val) {

		// 当要删除的内容在链表头
		while (head != null && head.val == val){
			ListNode listNode = head;
			head = head.next;
			listNode.next = null;
		}

		if (head == null){
			return null;
		}
		ListNode prev = head;
		while(prev.next != null){
			if (prev.next.val == val){
				ListNode delNode = prev.next;
				prev.next = delNode.next;
				delNode.next = null;
			}else {
				prev = prev.next;
			}
		}
		return head;
	}

	public static void main(String[] args){
		int[] arr = {1,2,3,4,5,4};
		ListNode node = new ListNode(arr);
		System.out.println(node.toString());
		day1_203 day1203 = new day1_203();
		ListNode listNode = day1203.removeElements1(node,4);
		System.out.println(listNode);
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }

	ListNode(int[] arr){
		if (arr.length == 0){
			throw new IllegalArgumentException("sdfs");
		}
		this.val = arr[0];
		ListNode cur = this;
		for (int i = 1; i < arr.length; i++) {
			cur.next = new ListNode(arr[i]);
			cur = cur.next;
		}
	}

	@Override
	public String toString() {
		StringBuilder res = new StringBuilder();
		ListNode cur = this;
		while (cur != null){
			res.append(cur.val).append("->");
			cur = cur.next;
		}
		res.append("NULL");
		return res.toString();
	}
}
