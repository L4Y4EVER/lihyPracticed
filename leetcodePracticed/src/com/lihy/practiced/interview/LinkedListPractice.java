package com.lihy.practiced.interview;

import com.lihy.practiced.bean.ListNode;

/**
 * 算法面试视频中的课程练习。
 *
 * 有序链表删除重复节点
 *
 * partition 操作链表，给定一个节点，确定其在链表中的位置
 *
 * 奇数位置排在偶数前面
 *
 * 两个链表数 逆序相加
 *
 * 两个链表数 顺序相加
 *
 *
 * 删除重复的元素2
 *
 * 合并两个有序的链表
 *
 * 25 题
 *
 * 147 实现插入排序
 * 148 sortList 归并排序
 *
 * 向右旋转k位
 *
 * reorder list 如何快速获取到 中间位置
 *
 * palindrome linked list  判断链表是否为 回文
 *
 *
 * @author hongyan
 * @date 2021/2/1
 */
public class LinkedListPractice {


    /**
     *
     * 删除倒数第几个元素
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNode(ListNode head,int n){
        if (head == null || n <= 0){
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = dummyHead;
        for (int i = 0; i < n ; i++){
            p = p.next;
        }

        ListNode q = dummyHead;
        while(p != null){
            p = p.next;
            q = q.next;
        }

        ListNode next = q.next;

        q.next = q.next.next;
        next.next = null;

        return dummyHead.next;

    }


    /**
     * 删除给定节点
     *
     * @param head
     * @return
     */
    public ListNode deleteNode(ListNode head){
        if (head == null){
            return head;
        }
        if (head.next == null){
            return null;
        }

        ListNode next = head.next;
        head.val = next.val;
        head.next = next.next;

        next.next = null;

        return head;

    }



    /**
     * 将两个相邻的节点进行交换。
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head){
        if(head == null){
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = dummyHead;
        while (p.next !=null && p.next.next != null){
            ListNode next = p.next;
            ListNode nextNext = p.next.next;
            ListNode next3 = p.next.next.next;

            p.next = nextNext;
            nextNext.next = next;
            next.next = next3;
            p = next;
        }

        return dummyHead.next;
    }



    /**
     * 递归的实现翻转链表
     *
     * @param head 头
     * @return 结果
     */
    public ListNode reverseLinkedList(ListNode head){
        if (head == null || head.next == null ){
            return head;
        }

        ListNode nextNode = reverseLinkedList(head.next);

        head.next.next = head;
        head.next = null;

        return nextNode;
    }

    /**
     * 遍历的方式处理链表
     *
     * @param head
     * @return
     */
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
