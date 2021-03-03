package com.lihy.practiced.twentytwentyone;

import java.util.*;

public class NiuClass {



    public static void jiami(){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine().toUpperCase();
            String s2 = sc.nextLine();
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            LinkedHashSet<Character> set = new LinkedHashSet();
            for (int i = 0; i < chars1.length; i++) {
                set.add(chars1[i]);
            }
            int k = 0;
            while (set.size() < 26) {
                char a = (char) ('A' + k);
                set.add(a);
                k++;
            }
            ArrayList<Character> list = new ArrayList<>(set);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < chars2.length; i++) {
                if (chars2[i] == ' ') {
                    sb.append(chars2[i]);
                } else if (chars2[i] < 'a') {
                    int n = (int) (chars2[i] - 'A');
                    char c = list.get(n);
                    sb.append(c);
                } else {
                    int n = (int) (chars2[i] - 'a');
                    char c = (char) (list.get(n) + 'a' - 'A');
                    sb.append(c);
                }

            }

            System.out.println(sb.toString());
        }
    }

    public static void juzhen(){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            StringBuffer str = new StringBuffer();
            int a = 1;
            int b = 0;
            for(int i=0;i<n;i++){
                a = a +i;
                b = a;
                for(int j=0;j<n-i;j++){
                    str.append(b+" ");
                    b = b+ j+i+2;
                }
                System.out.println(str.toString().trim());
                str = new StringBuffer();
            }
        }
    }



    public static String convert(String str) {
        int n = 4;
        if (str.contains(".")) {
            String[] fields = str.split("\\.");
            long result = 0;
            for (int i = 0; i < n; i++) {
                result = result * 256 + Integer.parseInt(fields[i]);
            }
            return "" + result;
        } else {
            long ipv4 = Long.parseLong(str);
            String result = "";
            for (int i = 0; i < n; i++) {
                result = ipv4 % 256 + "." + result;
                ipv4 /= 256;
            }
            return result.substring(0, result.length() - 1);
        }
    }

    private static String intToBinary(String ipSplit) {
        if (ipSplit.equals("0")){
            return "00000000";
        }
        String bin = Integer.toBinaryString(Integer.parseInt(ipSplit));
        int bitNum = 8;
        if (bin.length() < bitNum){
            bitNum -= bin.length();
            while (bitNum > 0){
                bin = "0"+bin;
                bitNum --;
            }
        }


        return bin;

    }

    private static void removeChar(String str) {
        Map<Character,Integer> map = new HashMap<>(16);
        int length = str.length();
        for (int i = 0; i < length; i++){
            char c = str.charAt(i);
            if (map.containsKey(c)){
                Integer integer = map.get(c);
                map.put(c,++integer);
            }else {
                map.put(c,1);
            }
        }

        int min = length;
        for (Integer value : map.values()) {
            min = Math.min(value,min);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++){
            char c = str.charAt(i);
            if (map.get(c) == min){
                continue;
            }
            sb.append(c);
        }

        System.out.println(sb.toString());


    }

    private static void drinkAeratedWater(int a) {
        if (a == 0){
            return;
        }
        int sum = 0;
        int yu = 0;
        while (a  >= 3){
            yu = a % 3;
            sum += a / 3;
            a = a / 3 + yu;
        }
        if ( a == 2){
            sum ++;
        }

        System.out.println( sum);
    }


    /**
     4 5 5
     1 5 5 10
     1 3 8 8 20
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            // 先获取全部的值
            String next = in.nextLine();
            String[] s = next.split(" ");
            int length = s.length;
            int[] ints = new int[length];
            for (int i=0;i < length ; i++ ){
                ints[i] = Integer.parseInt(s[i]);
            }

            Arrays.sort(ints);

            long maxNum = -1;

            for (int i = 0 ; i < length; i ++){
                StringBuilder str = new StringBuilder(ints[i] + "");
                for (int j = 0; j < length; j++){
                    if (j == i){
                        continue;
                    }
                    str.append(ints[j]);
                }
                long max = Long.parseLong(str.toString());
                maxNum = Math.max(max,maxNum);
            }
            System.out.println(maxNum);
        }
    }

    public static void test2(int m,int n, int r,Scanner in){

        // 分别初始化数组的值；
        int[] A = new int[m];
        for (int i = 0; i < m; i++){
            A[i] = in.nextInt();
        }

        int[] B = new int[n];
        for (int i = 0; i< n; i++){
            B[i] = in.nextInt();
        }

        for (int i = 0; i < m; i++){
            // 在B 中找 与A 最近且满足条件的点
            for (int j = 0; j < n ; j++) {

                if (B[j] - A[i] <= r && B[j] >= A[i]){
                    System.out.println(A[i]+" " + B[j]);
                    break;
                }

            }

        }
    }

    private static int findBj(int[] b, int i, int r) {
        // 其实就是在B 中找target 或者比 target 小且大于 i的数；结合B 的有序性进行二分查找
        int length = b.length;
        int left = 0;
        int right = length - 1;

        return findTarget(b,left,right,r,i);
    }

    private static int findTarget(int[] b, int left, int right, int target, int i) {
        if (b[right] < i){
            return 0;
        }
        int mid = right / 2;

        if (b[mid] - i > target){
            return findTarget(b,left,mid -1,target,i);
        } else {
            for (int x = left; x <= mid; x ++ ){
                if (b[x] - i <= target && b[x] -i >=0){
                    return b[x];
                }
            }
            return 0;
        }

    }

    public static void test1(int[] person,int power){

        int a = person.length;
        int pick = 0;

        // 当获取这么多内容后，遍历让两两结对，得到符合能力的结对
        for (int i= 0; i < a; i++){
            for (int j = i+1; j < a; j++){
                if (person[i] + person[j] == power){
                    pick ++;
                }
            }
        }

        System.out.println(pick);
    }

}
