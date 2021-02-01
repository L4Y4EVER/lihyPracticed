package com.lihy.practiced.interview;

import com.lihy.practiced.bean.ListNode;

/**
 * 算法面试视频中的课程练习。
 *
 * @author hongyan
 * @date 2021/2/1
 */
public class LinkedListPractice {




    public ListNode reverseLinkedList(ListNode head){
        if (head == null || head.next == null ){
            return head;
        }

        ListNode nextNode = reverseLinkedList(head.next);

        head.next.next = head;
        head.next = null;

        return nextNode;
    }

    public ListNode reverseList(ListNode head){
        if (head == null){
            return head;
        }

        ListNode preNode = null;
        ListNode curNode = head;

        while (curNode != null){
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }
        return preNode;
    }

    /**
     * 实现区间交换链表元素
     * 思路：
     * 找到开始位置之后，如同遍历去转换节点顺序
     * 注意点是要记录翻转的头与尾部，保证元素不丢。
     *
     * @param head 链表头
     * @param m 区间开始
     * @param n 区间结束
     * @return 结果
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null || m > n){
            return head;
        }
        int index = 1;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode preNode = dummyHead;
        ListNode curNode = head;

        while (curNode != null){

            ListNode next = curNode.next;
            if (index >= m && index <= n){
                ListNode pre = null;
                ListNode cur = curNode;

                while (index < n && cur !=null){
                    ListNode nextNode = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = nextNode;
                }

                preNode.next = pre;
                curNode.next = cur;
                break;
            }
            preNode = curNode;
            curNode = next;
            index ++;
        }
        return dummyHead.next;
    }
}
