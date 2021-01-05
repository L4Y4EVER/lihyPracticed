package com.lihy.practiced.twentytwentyone;

import com.lihy.practiced.bean.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 一月每日一题
 *
 * @author lhy
 * @date 2021/1/3
 */
public class JanuaryPracticed {

    /**
     * 0105
     * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
     *
     * 例如，在字符串 s = "abbxxxxzyy"中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
     *
     * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。上例中的 "xxxx" 分组用区间表示为 [3,6] 。
     *
     * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
     *
     * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
     *
     * @param s 字符串
     * @return 结果
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> lists = new ArrayList<>();
        int n = s.length();
        int num = 0;
        for (int i = 0; i < n; i++){
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    lists.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return lists;
    }

    /**
     * 0104
     *
     * 斐波那契数，通常用 F(n) 表示，形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
     * @param n 入参
     * @return 结果
     */
    public int fib(int n) {
        if ( n <= 0){
            return n;
        }
        if (n == 1){
            return 1;
        }
        return fib(n - 1) + fib(n-2);
    }



    /**
     * 0101
     *
     * @param flowerbed 入参数组
     * @param n 位置
     * @return 结果
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int m = flowerbed.length;
        int prev = -1;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (prev < 0) {
                    count += i / 2;
                } else {
                    count += (i - prev - 2) / 2;
                }
                prev = i;
            }
        }
        if (prev < 0) {
            count += (m + 1) / 2;
        } else {
            count += (m - prev - 1) / 2;
        }
        return count >= n;
    }


    /**
     * 0102
     *
     * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
     *
     * 返回滑动窗口中的最大值。
     *
     * @param nums 数组
     * @param k k
     * @return 结果
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        for (int i = 0; i < n; ++i) {
            if (i % k == 0) {
                prefixMax[i] = nums[i];
            }
            else {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
        }
        for (int i = n - 1; i >= 0; --i) {
            if (i == n - 1 || (i + 1) % k == 0) {
                suffixMax[i] = nums[i];
            } else {
                suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
            }
        }

        int[] ans = new int[n - k + 1];
        for (int i = 0; i <= n - k; ++i) {
            ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]);
        }
        return ans;
    }


    /**
     * 0103
     *
     * 给你一个链表和一个特定值 x ，请你对链表进行分隔，使得所有小于 x 的节点都出现在大于或等于 x 的节点之前。
     *
     * 你应当保留两个分区中每个节点的初始相对位置。
     *
     * @param head 头结点
     * @param x 分割地址
     * @return 返回链条
     */
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallHead = small;
        ListNode large = new ListNode(0);
        ListNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }
}
