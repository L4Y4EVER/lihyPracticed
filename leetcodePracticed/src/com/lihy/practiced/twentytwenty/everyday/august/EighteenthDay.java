package com.lihy.practiced.twentytwenty.everyday.august;

import com.lihy.practiced.bean.ListNode;
import com.lihy.practiced.bean.TreeNode;

/**
 * @author lihongyan
 * @date 2020/8/18
 */
public class EighteenthDay {
	ListNode globalHead;

	public TreeNode sortedListToBST(ListNode head) {
		globalHead = head;
		int length = getLength(head);
		return buildTree(0, length - 1);
	}

	public int getLength(ListNode head) {
		int ret = 0;
		while (head != null) {
			++ret;
			head = head.next;
		}
		return ret;
	}

	public TreeNode buildTree(int left, int right) {
		if (left > right) {
			return null;
		}
		int mid = (left + right + 1) / 2;
		TreeNode root = new TreeNode(0);
		root.left = buildTree(left, mid - 1);
		root.val = globalHead.val;
		globalHead = globalHead.next;
		root.right = buildTree(mid + 1, right);
		return root;
	}
}
