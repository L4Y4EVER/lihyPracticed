package com.lihy.practiced.twentytwenty.everyday.august;

import com.lihy.practiced.bean.TreeNode;

/**
 * 二叉树 最小深度
 *
 */
public class TwentyOnceDay {

    public int deathNode(TreeNode root){
        if (root == null){
            return 0;
        }
        if (root.right == null && root.left == null){
            return 1;
        }
        int deathNode = Integer.MAX_VALUE;
        if (root.left != null){
            deathNode = Math.min(deathNode(root.left),deathNode);
        }
        if (root.right !=null){
            deathNode = Math.min(deathNode(root.right),deathNode);
        }
        return deathNode + 1;
    }

    public static void main(String[] args) {
        //[3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(1);

        TwentyOnceDay twentyOnceDay = new TwentyOnceDay();
        System.out.println(twentyOnceDay.deathNode(root));
    }
}
