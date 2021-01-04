package com.lihy.practiced.twentytwenty.everyday.september;


import com.lihy.practiced.bean.TreeNode;

/**
 * @author lihongyan
 * @date 2020/9/23
 */
public class TwentyThirdDay {

    /**
     * 合并两颗二叉树
     *
     * @param treeOne 树1
     * @param treeTwo 树2
     * @return 合并以后的树
     */
    public TreeNode mergeTree(TreeNode treeOne, TreeNode treeTwo){

        if (treeOne == null && treeTwo == null){
            return null;
        }

        if (treeOne == null){
            return treeTwo;
        }
        if (treeTwo == null){
            return treeOne;
        }
        treeOne.val = treeOne.val + treeTwo.val;

        treeOne.left = mergeTree(treeOne.left,treeTwo.left);
        treeOne.right = mergeTree(treeOne.right,treeTwo.right);

        return treeOne;
    }
}
