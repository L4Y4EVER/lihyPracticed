package com.lihy.practiced.twentytwenty.everyday.october;


import com.lihy.practiced.bean.ListNode;

public class TenthDay {

    /**
     * 给定链表，判断有无换，有环返回成环位置
     *
     * @param head 链表头结点
     * @return 成环位置
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode slow = head,fast = head;

        while( fast != null){
            slow = slow.next;
            if (fast.next != null){
                fast = fast.next.next;
            }else {
                return null;
            }
            if (slow == fast){
                ListNode point = head;
                while (point != slow){
                    point = point.next;
                    slow = slow.next;
                }
                return point;
            }

        }
        return null;
    }
}
