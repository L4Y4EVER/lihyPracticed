package com.lihy.practiced.twentytwenty.everyday.september;


import com.lihy.practiced.bean.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SixthDay {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> linkedList = new LinkedList<>();
        if (root == null){
            return linkedList;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> level = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                if (treeNode != null) {
                    level.add(treeNode.val);
                    queue.offer(treeNode.left);
                    queue.offer(treeNode.right);
                }
            }
            linkedList.add(0,level);

        }


        return linkedList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> lists = levelOrderBottom(root);
        lists.forEach(list->{
            list.forEach(System.out::print);
            System.out.println();
        });
    }





}
