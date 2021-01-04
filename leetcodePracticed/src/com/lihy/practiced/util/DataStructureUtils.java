package com.lihy.practiced.util;


import com.lihy.practiced.bean.ListNode;
import com.lihy.practiced.bean.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

public class DataStructureUtils {

    public static ListNode array2ListNode(Integer[] arr){
        if (arr.length == 0 ){
            return null;
        }
        ListNode root = new ListNode(arr[0]);
        if (arr.length == 1){
            return root;
        }
        ListNode curNode = root;
        for (int i = 1; i < arr.length; i++) {
            curNode = curNode.next = new ListNode(arr[i]);

        }
        return root;
    }

    public static String listNode2String(ListNode root){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("链表root->");
        ListNode next = root;
        while (next != null){
            if (next.next == null){
                stringBuilder.append(next.val);
            }else {
                stringBuilder.append(next.val).append(",");
            }
            next = next.next;
        }
        stringBuilder.append(";");
        return stringBuilder.toString();
    }

    public static ListNode reverseList(ListNode head) {
        if ( head.next == null){
            return head;
        }
        ListNode next = head.next;
        ListNode reverse = reverseList(next);
        next.next = head;
        head.next = null;
        return reverse;
    }

    public static ListNode reverseListPlus(ListNode head) {
        return reverseList(head,null);
    }

    private static ListNode reverseList(ListNode head, ListNode reverse) {
        if (head == null || head.next == null){
            return head;
        }
        reverse = reverseList(head.next,reverse);
        head.next.next = head;
        head.next = null;
        return reverse;
    }

    public static ListNode reverseListPlusByStack(ListNode head) {
        Deque<ListNode> deque = new LinkedList<ListNode> ();
        for (ListNode next = head;next != null; next = next.next){
           deque.addLast(next);
        }
        ListNode root = deque.pollLast();
        ListNode curNode = root;
        while (!deque.isEmpty()) {
            ListNode node = deque.pollLast();
            curNode = curNode.next = node;
            node.next = null;
        }

        return root;
    }


    /**
     * 创建一个二叉树
     *
     * @param arr
     * @return
     */
    public static TreeNode array2TreeNode(Integer[] arr){
        if (arr.length == 0 ){
            return null;
        }
        TreeNode root = new TreeNode(arr[0]);
        if (arr.length == 1){
            return root;
        }
        TreeNode curNode = root;
        for (int i = 1; i < arr.length / 2 + 1; i++) {
            curNode.left = new TreeNode(arr[2*i -1]);
            curNode.right = new TreeNode(arr[2*i]);
        }
        return root;
    }

    /**
     * 删除节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    /**
     * 获取倒数第k个链表
     *
     * @param head
     * @param k
     * @return
     */
    public int kthToLast(ListNode head, int k) {
        ListNode curNode = head;
        for (int i = 0; i < k ; i ++){
            curNode = curNode.next;
        }
        ListNode slowNode = curNode;
        while(curNode.next != null){
            curNode = curNode.next;
            slowNode = slowNode.next;
        }
        return slowNode.val;
    }



    public static void main(String[] args) {
        Integer[] arr = new Integer[]{0,1,2,3,4,5,6};
        ListNode root = array2ListNode(arr);
        ListNode node3 = root.next.next;


    }
}
