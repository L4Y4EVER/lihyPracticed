package com.lihy.practiced.twentytwenty.everyday.august;

import java.util.List;

/**
 * @author lihongyan
 * @date 2020/9/1
 */
public class ThirtyOnceDay {
	boolean[] vis;
	int num;

	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int n = rooms.size();
		num = 0;
		vis = new boolean[n];
		dfs(rooms, 0);
		return num == n;
	}

	public void dfs(List<List<Integer>> rooms, int x) {
		vis[x] = true;
		num++;
		for (int it : rooms.get(x)) {
			if (!vis[it]) {
				dfs(rooms, it);
			}
		}
	}
}
