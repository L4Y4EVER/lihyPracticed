package com.lihy.practiced.twentytwenty.everyday.october;



import com.lihy.practiced.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lhy
 * @date 2020/10/29
 */
public class TwentyNinthDay {


    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

    List<String> arrayString = new ArrayList<>();

    public int sumNumbersTest(TreeNode root) {
        if (root == null){
            return 0;
        }
        StringBuilder start = new StringBuilder();
        sumNumbers(root,start);
        int result = 0;
        for (int i = 0; i < arrayString.size(); i++) {
            String s = arrayString.get(i);
            if (!s.equals("")){
                result += Integer.parseInt(s);
            }
        }
        return result;
    }


    public void sumNumbers(TreeNode node,StringBuilder start) {
        if (node == null){
            arrayString.add(start.toString());
            return;
        }
        start.append(node.val);
        sumNumbers(node.left,start);

        if (node.right != null){
            start.deleteCharAt(start.length() - 1);
            sumNumbers(node.right,start);
        }
    }

}
