package com.lihy.practiced.twentytwenty.everyday.october;


import com.lihy.practiced.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lihongyan
 * @date 2020/10/27
 */
public class TwentySeventhDay {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		preOrder(root,list);

		return list;
	}

	private void preOrder(TreeNode node, List<Integer> list) {
		if (node == null){
			return;
		}
		list.add(node.val);
		preOrder(node.left,list);
		preOrder(node.right,list);
	}
}
