package com.lihy.practiced.twentytwenty.everyday.september;


import com.lihy.practiced.bean.TreeNode;

/**
 * 反转二叉树
 *
 * @author lihongyan
 * @date 2020/9/16
 */
public class SixteenthDay {

	public TreeNode invertTree(TreeNode root){
		if (root == null){
			return null;
		}
		TreeNode left = root.left;
		root.left = root.right;
		root.right = left;
		invertTree(root.left);
		invertTree(root.right);

		return root;
	}
}
