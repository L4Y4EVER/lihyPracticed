package com.lihy.practiced.twentytwenty.everyday.september;

import com.lihy.practiced.bean.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lihongyan
 * @date 2020/9/28
 */
public class TwentyEighthDay {

	/**
	 * 填充右侧指针
	 *	层序遍历填充右侧指针
	 *
	 * @param root 入参
	 * @return 结果
	 */
	public Node connect(Node root) {
		if (root == null){
			return null;
		}

//		Node curNode = root;
		Queue<Node> deque = new LinkedList<>();
		deque.add(root);
		while (!deque.isEmpty()){
			Node perNode = null;
			int size = deque.size();
			for (int i = 0;i < size ;i++){

				Node curNode = deque.remove();

				if (curNode.left != null){
					deque.add(curNode.left);
				}
				if (curNode.right != null){
					deque.add(curNode.right);
				}

				if (perNode != null) {
					perNode.next = curNode;
				}
				perNode = curNode;
			}

		}
		return root;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2,new Node(4),new Node(5),null);
		root.right = new Node(3,null,new Node(7),null);
		TwentyEighthDay day = new TwentyEighthDay();
		day.connect(root);

	}
}
