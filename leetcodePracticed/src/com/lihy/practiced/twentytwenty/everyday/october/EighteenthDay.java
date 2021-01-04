package com.lihy.practiced.twentytwenty.everyday.october;


import com.lihy.practiced.bean.ListNode;

public class EighteenthDay {

    /**
     * 给定一个链表，删除链表倒数第n个结点;
     *
     * @param head 头结点
     * @param n 结点
     * @return 结果
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null){
            return null;
        }

        int start = 0;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode curNode = dummyHead;
        ListNode perNode = dummyHead;

        while (curNode != null){
            if (start > n){
                perNode = perNode.next;
            }
            if (curNode.next == null){
                ListNode next = perNode.next;
                perNode.next = next.next;
                next.next = null;
            }
            curNode = curNode.next;
            start ++;

        }
        return dummyHead.next;
    }
}
