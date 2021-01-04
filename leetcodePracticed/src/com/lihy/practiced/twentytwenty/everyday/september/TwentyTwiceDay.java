package com.lihy.practiced.twentytwenty.everyday.september;


import com.lihy.practiced.bean.TreeNode;

/**
 * 摄像头问题
 *
 * @author lihongyan
 * @date 2020/9/22
 */
public class TwentyTwiceDay {
	/**
	 * 深度优先遍历。
	 *
	 * @param root 入参
	 * @return 照相机数
	 */
	public int minCameraCover(TreeNode root) {
		int[] array = dfs(root);
		return array[1];
	}

	public int[] dfs(TreeNode root) {
		if (root == null) {
			return new int[]{Integer.MAX_VALUE / 2, 0, 0};
		}
		int[] leftArray = dfs(root.left);
		int[] rightArray = dfs(root.right);
		int[] array = new int[3];
		array[0] = leftArray[2] + rightArray[2] + 1;
		array[1] = Math.min(array[0], Math.min(leftArray[0] + rightArray[1], rightArray[0] + leftArray[1]));
		array[2] = Math.min(array[0], leftArray[1] + rightArray[1]);
		return array;
	}
}
