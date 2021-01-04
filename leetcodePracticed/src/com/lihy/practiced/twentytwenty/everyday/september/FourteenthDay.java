package com.lihy.practiced.twentytwenty.everyday.september;


import com.lihy.practiced.bean.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 使用循环的方式实现二分搜索树中序遍历
 *
 * @author lihongyan
 * @date 2020/9/14
 */
public class FourteenthDay {

	public List<Integer> inOrderT(TreeNode root){
		Deque<TreeNode> deque = new LinkedList<>();
		List<Integer>  list = new ArrayList<>();
		while ( root!= null || !deque.isEmpty()){
			// 先将左节点搞到底
			while (root != null){
				deque.push(root);
				root = root.left;
			}
			// 到底之后搞出来，放到list中
			root = deque.pop();
			list.add(root.val);
			root = root.right;
		}

		return list;

	}
}
