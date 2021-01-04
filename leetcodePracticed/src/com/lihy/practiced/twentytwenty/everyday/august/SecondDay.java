package com.lihy.practiced.twentytwenty.everyday.august;

import com.lihy.practiced.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SecondDay {

    public void flatten(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        traverse(nodeList,root);

        for (int i = 0; i < nodeList.size();i++ ){
            TreeNode cur = nodeList.get(i);
            cur.left = null;
            cur.right = nodeList.get(i+1);
        }
    }

    private void traverse(List<TreeNode> nodeList, TreeNode root) {
        if (root == null){
            return;
        }
        nodeList.add(root);
        traverse(nodeList,root.left);
        traverse(nodeList,root.right);
    }


}
