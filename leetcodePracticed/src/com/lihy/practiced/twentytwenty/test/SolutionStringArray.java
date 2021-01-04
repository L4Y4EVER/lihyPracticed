package com.lihy.practiced.twentytwenty.test;

import java.util.*;

/**
 * @author lihongyan
 * @date 2020/8/6
 */
public class SolutionStringArray {

	public static void main(String[] args){
	   String[] givenOrder = {"2#","E2#","5#","E5#","8#","E8#","0#","-1#","-2#"};
	   String[] list = {"-2#","E2#","-2#","8#","2#"};
	   List<String> given = Arrays.asList(givenOrder);
	   List<String> stringList = Arrays.asList(list);
		List<String> sort = sort(given, stringList);
		for (String string:sort) {
			System.out.println(string);
		}
	}

	public static List<String> sort(List<String> givenOrder, List<String> list){
		if(list==null||list.size()==0){
			return new ArrayList<>();
		}

		if(givenOrder==null||givenOrder.size()==0){
			throw new IllegalArgumentException("givenOrder is null");
		}

		if(givenOrder.size()==1){
			return list;
		}
		return sortIt(givenOrder,list);
	}

	public static List<String> sortIt(List<String> givenOrder,List<String> list){

		Map<String,Integer> map= new LinkedHashMap<>();
		for(int i=0;i<givenOrder.size();i++){
			map.put(givenOrder.get(i),0);
		}
		for(int i = 0;i<list.size();i++){
			map.put(list.get(i),map.get(list.get(i))+1);
		}
		List<String> res = new ArrayList();
		for(Map.Entry<String,Integer> en:map.entrySet()){
			for(int i = 0;i<en.getValue();i++){
				res.add(en.getKey());
			}
		}
		return res;
	}
}
