package com.lihy.practiced.twentytwenty.everyday.october;

/**
 * @author lihongyan
 * @date 2020/10/30
 */
public class ThirtiethDay {

	public int islandPerimeter(int[][] grid) {
		if (grid == null){
			return 0;
		}
		int landPerimeter = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int l = 0; l < grid[i].length; l++) {
				if (grid[i][l] == 1){
					landPerimeter +=helperPerimeter(i,l,grid);
				}
			}
		}

		return landPerimeter;
	}

	private int helperPerimeter(int i, int l,int[][] grid) {
		int landPerimeter = 4;
		int up = i - 1;
		int down = i + 1;
		int left = l - 1;
		int right = l + 1;

		if (left >= 0){
			if (grid[i][left] == 1){
				--landPerimeter;
			}
		}

		if (up >= 0){
			if (grid[up][l] == 1){
				--landPerimeter;
			}
		}

		if (right < grid[i].length){
			if (grid[i][right] == 1){
				--landPerimeter;
			}
		}

		if (down < grid.length){
			if (grid[down][l] == 1){
				--landPerimeter;
			}
		}
		return landPerimeter;
	}
}
