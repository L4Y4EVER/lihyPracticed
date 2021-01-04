package com.lihy.practiced.twentytwenty.everyday.september;

import java.util.*;

/**
 * 统计字符出现频率，并取出前 k个元素
 *
 * @author lihongyan
 * @date 2020/9/7
 */
public class SeventhDay {
	public int[] topListK(int[] arr,int k){
		if (arr.length <= 1 || k >= arr.length){
			return arr;
		}
		Map<Integer,Integer> map = new TreeMap<>();
		for (int i = 0; i < arr.length; i++) {
			int key = arr[i];
			map.merge(key, 1, (a, b) -> a + b);
		}
		int[] result = new int[k];
		

//		这里使用的tree的默认排序失败
//		Set<Integer> set = map.keySet();
//		Integer[] integers = new Integer[set.size()];
//		set.toArray(integers);
//
//		for (int i = 0; i < k; i++) {
//			result[i] = integers[i];
//		}

		// 使用优先队列
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
		for(Integer value : map.keySet()){
			if (priorityQueue.size() < k){
				priorityQueue.add(value);
			}else {
				priorityQueue.remove();
				priorityQueue.add(value);
			}
		}
		int i = 0;
		while (!priorityQueue.isEmpty()){
			Integer remove = priorityQueue.remove();
			result[i] = remove;
			i++;
		}
		return result;
	}
}
