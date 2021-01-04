package com.lihy.practiced.twentytwenty.everyday.september;


import com.lihy.practiced.bean.TreeNode;

/**
 * 二分搜索树变成 累加树
 * 反中序遍历
 *
 * @author lihongyan
 * @date 2020/9/21
 */
public class TwentyOnceDay {
	int sum =0;

	public TreeNode convertBST(TreeNode node) {
		if (node != null){
			convertBST(node.right);
			sum += node.val;
			node.val += sum ;
			convertBST(node.left);
			return  node;
		}
		return node;
	}
}
