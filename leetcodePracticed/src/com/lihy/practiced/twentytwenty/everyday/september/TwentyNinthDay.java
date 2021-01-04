package com.lihy.practiced.twentytwenty.everyday.september;


import com.lihy.practiced.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的后序遍历
 *
 * @author lihongyan
 * @date 2020/9/29
 */
public class TwentyNinthDay {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> nodeList = new ArrayList<>();
		postOrderTraversal(root,nodeList);
		return nodeList;
	}

	private void postOrderTraversal(TreeNode root, List<Integer> nodeList) {
		if (root == null){
			return;
		}
		postOrderTraversal(root.left,nodeList);
		postOrderTraversal(root.right,nodeList);
		nodeList.add(root.val);
	}
}
