package com.lihy.practiced.twentytwenty.everyday.october;


import com.lihy.practiced.bean.ListNode;

/**
 * leetcode 10月第3天题目
 *
 * @author superl
 * @date 20/10/04
 */
public class FourthDay {
    /**
     * 两数相加
     * 给出两个非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，并且它们的每个节点只能存储一位数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0开头。
     *
     *
     * @param l1 链表1
     * @param l2 链表2
     * @return 结果
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null,tail = null;
        int cur = 0;
        while (l1 != null || l2 != null){
            int l1Int = l1 != null ? l1.val : 0;
            int l2Int = l2 != null ? l2.val : 0;

            int sum = l1Int + l2Int + cur;
            if (head == null){
                head = tail = new ListNode(sum % 10);
            }else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            cur = sum / 10;

            l1 =  l1 != null ? l1.next : null;
            l2 =  l2 != null ? l2.next : null;
        }
        if (cur > 0){
            tail.next = new ListNode(cur);
        }

        return head;
    }
}
