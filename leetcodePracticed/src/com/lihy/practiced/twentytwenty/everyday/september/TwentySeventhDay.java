package com.lihy.practiced.twentytwenty.everyday.september;

import com.lihy.practiced.bean.TreeNode;

/**
 * 每日一题
 *
 * @author lihongyan
 * @date 2020/9/27
 */
public class TwentySeventhDay {

	/**
	 * 寻找两个节点的最近的公共父节点
	 *
	 * @param root 根节点
	 * @param p p
	 * @param q q
	 * @return 结果
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val < p.val && root.val < q.val){
			return lowestCommonAncestor(root.right,p,q);
		}else if (root.val > p.val && root.val > q.val){
			return lowestCommonAncestor(root.left,p,q);
		}
		return root;
	}
}
