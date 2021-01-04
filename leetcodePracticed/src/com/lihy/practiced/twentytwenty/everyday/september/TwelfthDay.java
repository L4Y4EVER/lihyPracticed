package com.lihy.practiced.twentytwenty.everyday.september;



import com.lihy.practiced.bean.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树平均层节点
 *
 * @author lihongyan
 * @date 2020/9/12
 */
public class TwelfthDay {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> doubles = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()){
			int size = queue.size();
			int sum = 0;
			Queue<TreeNode> nodes = new LinkedList<>(queue);
			while (!nodes.isEmpty()){
				TreeNode remove = queue.remove();
				nodes.remove();
				sum += remove.val;
				if (remove.right != null){
					queue.offer(remove.right);
				}
				if (remove.left != null){
					queue.offer(remove.left);
				}
			}
			doubles.add((double) (sum / size));
		}
		return doubles;
	}
}
