package com.lihy.practiced.twentytwenty.everyday.august;

import com.lihy.practiced.bean.TreeNode;

/**
 * 判断是否是平衡二叉树
 *
 * @author lihongyan
 * @date 2020/8/17
 */
public class SeventeenthDay {

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
		}
	}

	public int height(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(height(root.left), height(root.right)) + 1;
		}
	}
}
