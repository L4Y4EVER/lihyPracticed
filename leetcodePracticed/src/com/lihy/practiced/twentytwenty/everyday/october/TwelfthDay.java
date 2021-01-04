package com.lihy.practiced.twentytwenty.everyday.october;


import com.lihy.practiced.bean.TreeNode;

/**
 * @author lihongyan
 * @date 2020/10/12
 */
public class TwelfthDay {


	int pre;
	int ans;

	/**
	 * 获取树中 绝对值最小的差距
	 *
	 * @param root 树根节点
	 * @return 结果
	 */
	public int getMinimumDifference(TreeNode root) {
		ans = Integer.MAX_VALUE;
		pre = -1;
		dfs(root);
		return ans;
	}

	public void dfs(TreeNode root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		if (pre == -1) {
			pre = root.val;
		} else {
			ans = Math.min(ans, root.val - pre);
			pre = root.val;
		}
		dfs(root.right);
	}
}
