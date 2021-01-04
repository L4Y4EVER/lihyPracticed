package com.lihy.practiced.twentytwenty.everyday.october;


import com.lihy.practiced.bean.ListNode;
import com.lihy.practiced.util.DataStructureUtils;

import java.util.ArrayList;
import java.util.List;

public class TwentiethDay {

    public static void reorderList(ListNode head) {
        if (head == null){
            return;
        }
        ListNode curNode = head;
        List<ListNode> nodeList = new ArrayList<>();

        while(curNode != null){
            nodeList.add(curNode);
            curNode = curNode.next;
        }

        int size = nodeList.size();
        int mod = size / 2;
        for (int i = 0; i < mod; i++){
            ListNode perNode = nodeList.get(i);
            ListNode lastPerNode = nodeList.get(--size - 1);

            ListNode perNextNode = perNode.next;
            ListNode tarNode = lastPerNode.next;

            if (perNode.equals(lastPerNode)){
                return;
            }
            perNode.next = tarNode;
            tarNode.next = perNextNode;

            lastPerNode.next = null;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4};
        ListNode listNode = DataStructureUtils.array2ListNode(arr);
        reorderList(listNode);
        ListNode curNode = listNode;
        while (curNode != null){
            System.out.println(curNode.val);
            curNode = curNode.next;
        }


    }
}
