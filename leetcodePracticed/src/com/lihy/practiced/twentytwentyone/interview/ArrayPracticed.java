package com.lihy.practiced.twentytwentyone.interview;

/**
 * @author hongyanli
 * @since 2021/3/8 15:45
 */
public class ArrayPracticed {


    public static void main(String[] args) {
//        int size = 10000000;
//        int[] nums1 = new int[size];
//
//        for (int i = 0; i < size; i++){
//            nums1[i] = i;
//        }
//
//        System.out.println(binarySearch(nums1,10));
//
//        int[] nums2 = {1,0,3,0,2};
//        moveZero(nums2);
//        for (int num : nums2) {
//            System.out.println(num);
//        }

        int[] nums3 = {0,0,0,1,1,2,3,3,5};
        int num = removeDuplicatesPlus(nums3);
        for (int i = 0; i < num; i++){
            System.out.println(nums3[i]);
        }

    }

    /**
     *
     * @param nums
     */
    public void sortColors(int[] nums) {

    }


    /**
     * 删除数组中的为0 数
     *
     * @param nums 数组
     */
    public static void moveZero(int[] nums){
        if (nums.length == 0){
            return;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                if (k != i){
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                }
                k++;
            }
        }
    }

    /**
     * 在指定元素中移除指定值并返回新数组的长度
     * 便利一次数组，用另一个数组接收，用到了O(n)的时间复杂度
     *
     * 便利一次数组，将非等值的元素维护在数组前端，索引递增，
     * 索引维护到的位置也就是所有非等值元素
     *
     * @param nums 目标数组
     * @param val 指定值
     * @return 新数组长度
     */
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
                if (i != k){
                  int temp = nums[k];
                  nums[k] = nums[i];
                  nums[i] = temp;
                }
                k++;
            }
        }
        return k;
    }

    /**
     * 删除重复数值
     * 根据有序数组的特性，遍历的过程中将k之前的数都是不同的数
     * 0 0 1 1 2 3
     * 维护k 个元素的数组，主要是拿第k 个元素为判断不同的标准，也就是其实该数组的长度最后要加1
     * 始终是由k 开始，i 为第二个元素进行比较
     *
     * @param nums nums
     * @return 删除后的数组长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int k = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k]){
                if (k != i){
                    k++;
                    nums[k] = nums[i];
                }
            }
        }

        return k + 1;
    }


    /**
     * 每个元素最多出现2次,有序数组
     * 依照上面的条件，还是类似的维护到k 的元素都是满足至多出现两次的
     * 又因为是有序的，出现次数可以累加，判断是否达到一个数，就可以满足2次的条件了
     * 这个时候就是，每个数都要判断，不仅如次还要判断是否等于一个值
     *
     * @param nums 目标处理数组
     * @return 结果
     */
    public static int removeDuplicatesPlus(int[] nums) {
        if (nums.length == 0){
            return 0;
        }

        int k = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == nums[i - 1] ){
                count++;
            }
            else {
                count = 1;
            }
            if (count <= 2){
                nums[++k] = nums[i];
            }

        }

        return k + 1;
    }



    /**
     * 对有序数组进行二分查找。
     * 这里面如果中位数计算在循环过程中反复生成并赋值会比循环外声明一个变量多占用一点儿内存
     *
     * @param nums 目标数组
     * @param k 目标数字在数组中下标
     * @return 返回结果
     */
    public static int binarySearch(int[] nums,int k){
        if (nums.length == 0){
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left <= right){
            mid = left + (right - left) / 2;
            if (nums[mid] == k){
                return mid;
            }else if (nums[mid] < k){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return -1;
    }

}
