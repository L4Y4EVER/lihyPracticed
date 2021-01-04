package com.lihy.practiced.twentytwenty.test;



import java.util.*;

/**
 * leetcode 题目联系类
 * leetcode 题目联系类
 *
 * @author lihongyan
 */
public class Solution {


	/**
	 * 347号问题
	 * 前K个高频元素
	 *
	 * 优先级定义方式，不同的定义，会导致不同的表现
	 * @param nums 入参
	 * @param k k
	 * @return 结果
	 */
	public static int[] topKFrequent(int[] nums, int k){
		TreeMap<Integer,Integer> map = new TreeMap<>();
		for (int num:nums){
			if(map.containsKey(num)){
				map.put(num,map.get(num) + 1);
			}else {
				map.put(num,1);
			}
		}

		// 内部最小堆
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(map::get));
		for (Integer integer : map.keySet()) {
			if (priorityQueue.size() < k){
				priorityQueue.add(integer);
			}else if (map.get(integer) > priorityQueue.peek()){
				priorityQueue.remove();
				priorityQueue.add(integer);
			}
		}
		int[] numss = new int[k];
		int i = 0;

		while (!priorityQueue.isEmpty()){
			numss[i] = priorityQueue.remove();
			i++;
		}

		return numss;

	}

	/**
	 * 349号问题
	 *
	 * @param nums1 数组
	 * @param nums2 数组
	 * @return 结果
	 */
	public int[] intersection349(int[] nums1, int[] nums2) {
		TreeSet<Integer> set = new TreeSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int num:nums1){
			set.add(num);
		}
		for (int num : nums2){
			if (set.contains(num)) {
				list.add(num);
				set.remove(num);
			}
		}
		int[] ints = new int[list.size()];
		for (int i = 0; i < list.size(); i++){
			ints[i] = list.get(i);
		}
		return ints;
	}

	/**
	 * 305号问题
	 *
	 * @param nums1 数组
	 * @param nums2 数组
 	 * @return
	 */
	public int[] intersection350(int[] nums1, int[] nums2) {
		TreeMap<Integer,Integer> treeMap = new TreeMap<>();
		ArrayList<Integer> list = new ArrayList<>();


		for (int num:nums1){
			if (treeMap.containsKey(num)){
				treeMap.put(num,1);
			}else {
				treeMap.put(num,treeMap.get(num) + 1);
			}
		}
		for (int num : nums2){
			if (treeMap.containsKey(num)) {
				list.add(num);
				treeMap.put(num,treeMap.get(num) -1);
				if (treeMap.get(num) == 0){
					treeMap.remove(num);
				}
			}
		}
		int[] ints = new int[list.size()];
		for (int i = 0; i < list.size(); i++){
			ints[i] = list.get(i);
		}
		return ints;
	}

	/**
	 * 804 号问题
	 *
	 * @param words 单词
	 * @return 结果
	 */
	public int uniqueMorseRepresentations(String[] words) {
		String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
		TreeSet<String> set =new TreeSet<>();
		StringBuilder res = new StringBuilder();
		for (String word: words){
			for (int i = 0; i < word.length(); i--) {
				res.append(codes[word.charAt(i) - 'a']);
			}
			set.add(res.toString());
		}
		return set.size();
	}

	/**
	 * 翻转元音字母
	 *
	 * @param s 字符串
	 * @return 翻转后的字符串
	 */
	public String reverseVowels(String s) {
		char[] chars = s.toCharArray();
		int right = chars.length - 1;
		int left = 0;
		String ss = "aeiouAEIOU";

		while ( left < right){
			while (ss.indexOf(chars[left]) != -1){
				left++;
			}
			while (ss.indexOf(chars[right]) != -1){
				right--;
			}
			char temp =  chars[left];
			chars[left++] = chars[right];
			chars[right--] = temp;
		}
		return new String(chars);
	}

	/**
	 * 翻转字符串
	 *
	 * @param s 字符数组
	 */
	public void reverseString(char[] s) {
		int right = s.length - 1;
		int left = 0;
		while ( left < right){
			char temp =  s[left];
			s[left++] = s[right];
			s[right--] = temp;
		}
	}


	/**
	 * 官方解答方式
	 *
	 * @param s 入参
	 * @return 是否为回文串。
	 */
	public boolean isPalindromeOfficial(String s) {
		int n = s.length();
		int left = 0, right = n - 1;
		while (left < right) {
			// 此判断 如果是不是字母或者数组进行跳过
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
				++left;
			}
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				--right;
			}
			if (left < right) {
				if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
					return false;
				}
				++left;
				--right;
			}
		}
		return true;
	}

	/**
	 * 判断字符串是否是回文串
	 *
	 * @param s 入参字符串
	 * @return 结果
	 */
	public boolean isPalindrome(String s) {
		if (s.length() == 0){
			return true;
		}
		String regEx="[\n`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。， 、？_\"]";
		s = s.toUpperCase();
		s = s.replaceAll(regEx,"");
		int l = 0;
		int r = s.length() - 1;

		while (l < r){
			if (s.charAt(l++) != s.charAt(r--)){
				return false;
			}
		}
		return true;

	}


	/**
	 * 基于双指针对撞实现基于有序数组，找到两数之和
	 *
	 * @param numbers 有序的递增数组
	 * @param target 和
	 * @return 结果
	 */
	public int[] twoSumPlus(int[] numbers, int target) {
		int i = 0;
		int j = numbers.length -1;
		while (i <= j){
			if (numbers[i]+ numbers[j] > target){
				j--;
			}else if (numbers[i]+ numbers[j] < target ){
				i++;
			}else {
				return new int[]{i+1,j+1};
			}
		}
		return null;

	}

	/**
	 * 找到两个值得和是target 的下标
	 * 已知两数之和和其中一个数，求另一个数，
	 * 二分法实现
	 *
	 * @param numbers 数组
	 * @param target 目标
	 * @return 结果
	 */
	public int[] twoSum(int[] numbers, int target) {

		for (int i = 0; i < numbers.length; i++) {
			int right = numbers.length;
			int number = numbers[i];
			int tar = target - number;
			int left = i + 1;
			while (left < right){
				// 防止下标越界
				int mid = (right - left) / 2 + left;
				if (tar < numbers[mid]){
					right = mid;
				}else if (tar > numbers[mid]){
					left = mid + 1;
				}else {
					return new int[]{i,mid};
				}
			}
		}
		return null;
	}

	/**
	 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
	 *
	 * @param nums 未排序数组
	 * @param k 第k大的元素
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
		return quickSort(nums,0,nums.length-1,k -1);
	}

	private int quickSort(int[] nums, int left, int right, int k) {
		if (left > right){
			return 0;
		}
		int partition = partition(nums,left,right);
		if (k < partition){
			return 	quickSort(nums,left,partition,k);
		}
		if (k > partition){
			return 	quickSort(nums,partition + 1,right,k);
		}

		return nums[partition];
	}

	private int partition(int[] nums, int left, int right) {
		int sign = nums[left];
		int j = left;
		for (int i = left + 1; i <= right; i++){
			if (nums[i] > sign){
				swap(nums,j+1,i);
				j ++;
			}
		}
		swap(nums,j,left);
		return j;
	}


	/**
	 * 删除数组中的 为0的元素
	 *
	 * @param nums 数组
	 */
	public void moveZeros(int[] nums){
		int i = 0;
		for (int j = 1; j < nums.length; j ++){
			if (nums[i] == 0){
				swap(nums,i,j);
				if (nums[i] != 0){
					i++;
				}
			}
		}

	}


	/**
	 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
	 *
	 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
	 *
	 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
	 *
	 * @param nums 数组
	 * @param val 元素
	 * @return
	 */
	public int removeElement(int[] nums, int val) {
		int size = nums.length -1;
		int i = 0;
		while(i <= size){
			if (nums[i] == val){
				swap(nums,size,i);
				size --;
			}else if (nums[i] != val){
				i++;
			}
		}

		return size + 1;
	}

	/**
	 * 删除数组中重复数据 空间O(1)
	 *
	 * @param nums 数组
	 * @return 结果
	 */
	public int removeDuplicates(int[] nums) {
		int i = 0;

		for (int j =1; j < nums.length; j ++ ){
			if (nums[i] != nums[j]){
				i++;
				nums[i] = nums[j];
			}
		}
		return i + 1;
	}

	/**
	 * 删除数组中重复数据 且保留最大k个 空间O(1)
	 *
	 * @param nums 数组
	 * @return 数组长度
	 */
	public int removeDuplicates(int[] nums,int k) {
		int i = 1;
		int count = 1;

		for (int j =1; j < nums.length; j ++ ){
			if (nums[j] == nums[j - 1] ){
				count++;
			}
			else {
				count = 1;
			}
			if (count <= 2){
				nums[i++] = nums[j];
			}
		}
		return i ;
	}


	/**
	 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
	 * 并按照红色、白色、蓝色顺序排列。
	 *
	 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
	 *
	 * @param nums 需要排序的数组
	 * @return 结果
	 */
	public int[] sortColors(int[] nums){
		if (nums.length == 0){
			return nums;
		}
		int[] arr = new int[3];
		for (int i = 0; i < nums.length; i++){
			// 循环一遍统计出各个元素出现的次数
			arr[nums[i]]++;
		}
		int x = 0;
		for (int i = 0; i < arr.length; i ++){
			for (int j = 0; j < arr[i]; j ++){
				nums[x++] = i;
			}
		}
		return nums;
	}


	/**
	 * 三路快排的方式，解决三颜色排序问题。
	 * 预测 三色排序是 25日每日一题。
	 *
	 * @param nums
	 */
	public void sortColorsThreeWay(int[] nums){
		if (nums.length == 0){
			return;
		}
		// 左标定点
		int left = 0;
		// 右标定点
		int right = nums.length -1;
		// 定义游走的浮标
		int i = 0;
		// i = right 的时候这个元素没有判断过。
		while (i <= right){
			if (nums[i] == 1){
				i++;
			}else if (nums[i] < 1){
				swap(nums,left,i);
				i++;
				left++;
			}else {
				swap(nums,right,i);
				right --;
			}

		}
	}


	/**
	 * 使用归并排序的思路，从后往前的对比
	 * 不许要开辟额外的空间，从后往前的往里头插入
	 *
	 * @param nums1 数组1
	 * @param m 容量
	 * @param nums2 数组2
	 * @param n 容量
	 */
	public void mergePlusPlus(int[] nums1, int m, int[] nums2, int n) {
		int i = m + n - 1;
		int n1 = m - 1;
		int n2 = n -1;

		while ((n2 >= 0) && (n1 >= 0)){
			nums1[i--] = (nums1[n1] < nums2[n2]) ? nums2[n2--] : nums1[n1--];
		}
		// 源数组数组 起始位置  目标数组  目标复制位置 结束位置
		System.arraycopy(nums2, 0, nums1, 0, n2 + 1);
	}

	/**
	 * 使用归并排序的思路，从前往后的对比
	 * 需要开辟 m个空间 保存 nums1 的有效容量
	 *
	 * @param nums1 数组1
	 * @param m 容量
	 * @param nums2 数组2
	 * @param n 容量
	 */
	public void mergePlus(int[] nums1, int m, int[] nums2, int n) {
		int[] num1_copy = new int[m];
		System.arraycopy(nums1, 0, num1_copy, 0, m);
		int i = 0;
		int n1 = 0;
		int n2 = 0;
		while ((n1 < m)  && (n2 < n)){
			nums1[i++] = (num1_copy[n1] < nums2[n2]) ? num1_copy[n1++] : nums2[n2++];
		}

		if (n2 < n) {
			System.arraycopy(nums2, n2, nums1, n1+n2, m + n -n1 -n2 );
		}

		if (n1 < m) {
			System.arraycopy(num1_copy, n1, nums1, n1+n2, m + n -n1 -n2);
		}
	}

	/**
	 * 合并两个有序数组
	 * 三路快排 实现一次循环进行排序
	 *
	 *
	 * @param nums1 nums1
	 * @param m m
	 * @param nums2 nums2
	 * @param n n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// 将两个有序的数组合并到一起
		if (m + n - m >= 0) {
			System.arraycopy(nums2, 0, nums1, m, m + n - m);
		}

		// 找到nums 1数组的中点
		int right = m + n - 1;
		int left = 0;

		// 使用选择排序进行排序
//		selectedSort(nums1);

		quickSortThreeWay(nums1,left,right);
	}
	/**
	 * 三路快排
	 *
	 * @param nums1
	 * @param left
	 * @param right
	 */
	private void quickSortThreeWay(int[] nums1, int left, int right) {

		if (left >= right){
			return;
		}
		swap(nums1,left,new Random().nextInt(right - left + 1) + left);
		int sign = nums1[left];

		int l = left;
		int i = left + 1;
		int r = right + 1;
		while ( i < r){
			if (nums1[i] < sign){
				swap(nums1,++l,i++);
			}else if (nums1[i] > sign){
				swap(nums1,i,--r);
			}else {
				i++;
			}
		}
		swap(nums1,left,l);
		quickSortThreeWay(nums1,left,l - 1 );
		quickSortThreeWay(nums1,r,right);

	}

	/**
	 * 选择排序 给数组排序
	 *
	 * @param nums1 元素
	 */
	private void selectedSort(int[] nums1) {
		if (nums1.length == 0){
			return;
		}
		for (int i = 0; i < nums1.length; i ++){
			int min = 0;
			for (int j = i; j < nums1.length; j++){
				if (nums1[j] <= nums1[min]){
					min = j;
				}
			}
			swap(nums1,min,i);
		}
	}

	private void swap(int[] nums, int size, int i) {
		int num = nums[i];
		nums[i] = nums[size];
		nums[size] = num;
	}

	/**
	 * 227 号问题解答使用内部类的形式整理代码
	 *
	 */
	private class innerSolution{

		private int[] sum;


		public innerSolution(int[] nums) {
			this.sum = new int[nums.length + 1];
			sum[0] = nums[0];
			for (int i = 1;i<nums.length;i++){
				sum[i] = nums[i] + sum[i-1];
			}
		}

		public int sumRange(int i, int j) {
			return sum[j] - sum[i];
		}
	}
}


