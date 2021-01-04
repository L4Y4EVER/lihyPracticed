package com.lihy.practiced.twentytwenty.everyday.october;


import com.lihy.practiced.bean.ListNode;

/**
 * @author lihongyan
 * @date 2020/10/13
 */
public class ThirteenthDay {

	/**
	 *
	 *
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode newHead = head.next;
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}


	public ListNode swapPairsTransfer(ListNode head) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode curNode = dummyHead;
		while (curNode.next != null || curNode.next.next != null){
			ListNode next = curNode.next;
			ListNode next1 = curNode.next.next;
			curNode.next = next1;
			next1.next = next;
			next.next = next1.next;

			curNode = next;

		}
		return dummyHead.next;
	}


}
