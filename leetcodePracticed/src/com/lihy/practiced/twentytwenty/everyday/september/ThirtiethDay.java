package com.lihy.practiced.twentytwenty.everyday.september;


import com.lihy.practiced.bean.TreeNode;

public class ThirtiethDay {
    /**
     * 像二叉查找树中添加元素
     *
     * @param root root
     * @param val val
     * @return 结果
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        if (root.val < val){
            root.right = insertIntoBST(root.right,val);
            return root;
        }else if (root.val > val){
            root.left = insertIntoBST(root.left,val);
            return root;
        }else {
            return root;
        }
    }
}
