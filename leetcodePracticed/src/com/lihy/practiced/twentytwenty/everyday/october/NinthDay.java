package com.lihy.practiced.twentytwenty.everyday.october;


import com.lihy.practiced.bean.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lihongyan
 * @date 2020/10/9
 */
public class NinthDay {

	public boolean hasCycle(ListNode head) {
		if(head == null){
			return false;
		}
		ListNode  cur = head;
		Set<ListNode> set = new HashSet<>();
		while (cur != null){
			set.add(cur);
			cur = cur.next;
			if (set.contains(cur)){
				return true;
			}
		}
		return false;
	}
}
