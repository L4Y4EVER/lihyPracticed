package com.lihy.practiced.twentytwenty.everyday.september;


import com.lihy.practiced.bean.TreeNode;

/**
 * 由于对左叶子节点的误会导致了，不能快速的进行解题。
 * 对题目的理解有多么的重要。
 *
 */
public class NineteenthDay {

    public int sumOfLeftLeaves(TreeNode root) {
        return sumLeft(root,false);
    }
    public int sumLeft(TreeNode node,boolean plus){
        if( node == null){
            return 0;
        }
        int sum = 0;
        if(plus && node.left == null && node.right == null){
            sum += node.val;
        }
        sum += sumLeft(node.left,true);
        sum += sumLeft(node.right,false);
        return sum;
    }
}
