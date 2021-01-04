package com.lihy.practiced.twentytwenty.everyday.september;


import com.lihy.practiced.bean.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lihongyan
 * @date 2020/9/24
 */
public class TwentyFourthDay {

	/**
	 * 前一个值,用最小的值表示
	 */
	private int preValue = Integer.MIN_VALUE;
	/**
	 * 出现就是1
	 */
	private int count = 1;
	/**
	 * 最大的出现次数
	 */
	private int max = 0;


	/**
	 * 寻找二分搜索树中的 所有众数（出现最多的元素）
	 * 相等的元素会出现在左子树，谁的左子树最长且相同 就是谁
	 *
	 * @param root
	 * @return
	 */
	public int[] findMode(TreeNode root) {

		List<Integer> result = new ArrayList<>();

		find(root,result);

		if (result.isEmpty()){
			return null;
		}
		int[] arr = new int[result.size()];
		for (int i = 0; i < result.size(); i++){
			arr[i] = result.get(i);
		}

		return arr;
//		Integer size = result.get(result.size() - 1);
		// 用数组下标记录 数字出现次数的想法 落空了，数据太大会导致不能创建那么大的数组。
		// 可以使用 那个啥的思想 哈希表的思想 hash 的思想我还是不行，跳过吧，再改改。

	}

	/**
	 * 将节点顺序的遍历
	 * 遍历的过程中判断是否为连续的值
	 *
	 * @param node node 节点
	 * @return 结果
	 */
	public void find(TreeNode node,	List<Integer> result){
		if (node == null){
			return ;
		}
		find(node.left,result);
		if (node.val != preValue){
			count = 1;
		}else {
			count ++;
		}
		if (count > max){
			max = count;
			result.clear();
			result.add(node.val);
		}else if ( count == max){
			result.add(node.val);
		}

		preValue = node.val;
		find(node.right,result);
	}


	/**
	 * 遍历的方式实现中序遍历
	 *
	 * @param root 节点
	 * @return 结果
	 */
	public  int[] findModePlus(TreeNode root){
		if (root ==  null){
			return new int[0];
		}
		int preV = Integer.MIN_VALUE;
		int count = 1;
		int max = 0;

		List<Integer> results = new ArrayList<>();
		Deque<TreeNode> deque = new LinkedList<>();
		TreeNode currentNode = root;
		while (!deque.isEmpty() || currentNode != null){
			// 这里一直将左节点 全部入栈 先进后出的特性，是的没错了
			while (currentNode != null){
				// preOrder
				deque.push(currentNode);
				currentNode = currentNode.left;
			}
			// 将上一个节点出站 然后 找右节点
			currentNode = deque.pop();
			if (preV == currentNode.val){
				count ++;
			}else {
				count = 1;
			}

			if (max < count) {
				max = count;
				results.clear();
				results.add(currentNode.val);
			}else if (count == max){
				results.add(currentNode.val);
			}

			preV = currentNode.val;
			// 在这里进行inOrder 的操作未
			currentNode = currentNode.right;
		}

		int[] resultArray = new int[results.size()];
		for (int i = 0; i < resultArray.length; i ++){
			resultArray[i] = results.get(i);
		}
		return resultArray;
	}
	public static void main(String[] args){
	    TreeNode root = new TreeNode(1);
	    root.right = new TreeNode(2);
	    root.right.left = new TreeNode(2);

		TwentyFourthDay twentyFourthDay = new TwentyFourthDay();
		int[] mode = twentyFourthDay.findModePlus(root);

		System.out.println();


	}
}
