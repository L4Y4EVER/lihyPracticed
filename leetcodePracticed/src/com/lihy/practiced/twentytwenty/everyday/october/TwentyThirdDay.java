package com.lihy.practiced.twentytwenty.everyday.october;


import com.lihy.practiced.bean.ListNode;

import java.util.ArrayList;
import java.util.List;

public class TwentyThirdDay {

    public boolean isPalindrome(ListNode head) {
        if (head == null){
            return true;
        }
        ListNode curNode = head;
        List<ListNode> listNodes = new ArrayList<>(16);
        while (curNode != null){
            listNodes.add(curNode);
            curNode = curNode.next;
        }

        int size = listNodes.size();
        int left = 0;
        int right = size - 1;
        while (left < right){
            if (listNodes.get(left++).val != listNodes.get(right --).val){
                return false;
            }
        }
        return true;
    }
}
