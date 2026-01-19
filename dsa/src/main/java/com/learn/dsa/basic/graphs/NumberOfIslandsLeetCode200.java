package com.learn.dsa.basic.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author karthik
 *Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
 */
public class NumberOfIslandsLeetCode200 {

	public static void main(String[] args) {

		// Create an instance of the Solution class
		NumberOfIslandsLeetCode200 solution = new NumberOfIslandsLeetCode200();

		 char[][] grid1 = {
		            {'1', '1', '1', '1', '0'},
		            {'1', '1', '0', '1', '0'},
		            {'1', '1', '0', '0', '0'},
		            {'0', '0', '0', '0', '0'}
		        };
		        System.out.println("Test case 1: Single island");
		        System.out.println("Original grid:");
		        printGrid(grid1);
		        int result1 = solution.numIslands(grid1);
		        System.out.println("Number of islands: " + result1); // Expected: 1
		        System.out.println("---");

		        // --- Test case 2: A grid with multiple islands ---
		        char[][] grid2 = {
		            {'1', '1', '0', '0', '0'},
		            {'1', '1', '0', '0', '0'},
		            {'0', '0', '1', '0', '0'},
		            {'0', '0', '0', '1', '1'}
		        };
		        System.out.println("Test case 2: Multiple islands");
		        System.out.println("Original grid:");
		        printGrid(grid2);
		        int result2 = solution.numIslands(grid2);
		        System.out.println("Number of islands: " + result2); // Expected: 3
		        System.out.println("---");

		        // --- Test case 3: An empty grid ---
		        char[][] grid3 = {};
		        System.out.println("Test case 3: Empty grid");
		        System.out.println("Original grid: []");
		        int result3 = solution.numIslands(grid3);
		        System.out.println("Number of islands: " + result3); // Expected: 0
		        System.out.println("---");

		        // --- Test case 4: A grid with no islands (all water) ---
		        char[][] grid4 = {
		            {'0', '0', '0'},
		            {'0', '0', '0'},
		            {'0', '0', '0'}
		        };
		        System.out.println("Test case 4: All water");
		        System.out.println("Original grid:");
		        printGrid(grid4);
		        int result4 = solution.numIslands(grid4);
		        System.out.println("Number of islands: " + result4); // Expected: 0
		        System.out.println("---");
		    }

    // Helper method to print the grid for visualization
    public static void printGrid(char[][] grid) {
        if (grid == null || grid.length == 0) {
            System.out.println("[]");
            return;
        }
        for (char[] row : grid) {
            System.out.println(java.util.Arrays.toString(row));
        }
    }

	
	public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int numRows = grid.length;
        int numCols = grid[0].length;
        int islandCount = 0;
        
        // Iterate over each cell in the grid
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < numCols; c++) {
                // If a land cell is found, start a DFS
                if (grid[r][c] == '1') {
                    islandCount++;
                    dfs(grid, r, c);
                }
            }
        }
        
        return islandCount;
    }
    
    // DFS function to explore and mark an entire island
    private void dfs(char[][] grid, int r, int c) {
        int numRows = grid.length;
        int numCols = grid[0].length;
        
        // Base case: check for out-of-bounds, water, or already visited cells
        if (r < 0 || r >= numRows || c < 0 || c >= numCols || grid[r][c] == '0') {
            return;
        }
        
        // Mark the current cell as visited by changing '1' to '0'
        grid[r][c] = '0';
        
        // Recursively call DFS on all valid neighbors (up, down, left, right)
        dfs(grid, r + 1, c); // Down
        dfs(grid, r - 1, c); // Up
        dfs(grid, r, c + 1); // Right
        dfs(grid, r, c - 1); // Left
    }

}
