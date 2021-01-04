package com.lihy.practiced.twentytwenty.everyday.august;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 复制图
 *
 * @author lihongyan
 * @date 2020/8/12
 */
public class TwelfthDay {


	private HashMap<Node, Node> visited = new HashMap <> ();
	public Node cloneGraph(Node node) {
		if (node == null) {
			return node;
		}

		// 如果该节点已经被访问过了，则直接从哈希表中取出对应的克隆节点返回
		if (visited.containsKey(node)) {
			return visited.get(node);
		}

		// 克隆节点，注意到为了深拷贝我们不会克隆它的邻居的列表
		Node cloneNode = new Node(node.val, new ArrayList());
		// 哈希表存储
		visited.put(node, cloneNode);

		// 遍历该节点的邻居并更新克隆节点的邻居列表
		for (Node neighbor: node.neighbors) {
			cloneNode.neighbors.add(cloneGraph(neighbor));
		}
		return cloneNode;
	}
}
class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
		val = 0;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val) {
		val = _val;
		neighbors = new ArrayList<Node>();
	}

	public Node(int _val, ArrayList<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}
