package com.lihy.practiced.twentytwenty.everyday.october;


import com.lihy.practiced.bean.Node;

/**
 *
 * superL
 * 10-15
 */
public class FifteenthDay {

    /**
     * 遍历将节点连接右侧
     *
     * @param root 入参
     * @return 结果
     */
    public Node connect(Node root) {
        if (root == null){
            return null;
        }
        connectPlus(root.left,root.right);
        return root;
    }

    /**
     * 使用递归的方法实现左右连接。
     *
     * @param left 左节点
     * @param right 右结点
     */
    private void connectPlus(Node left, Node right) {
        if(left == null || right == null){
            return;
        }
        left.next = right;
        connectPlus(left.left,left.right);
        connectPlus(right.left,right.right);

        connectPlus(left.right,right.left);
    }
}
