package com.learn.dsa.basic.graphs;
/**
 * 24th August 2025
 * @author karthik
In this problem, we are given an infinite chess board that can be imagined as an endless grid with 
coordinates ranging from negative infinity to positive infinity. 
We have a chess piece—a knight—placed at the origin [0, 0] of this grid. 
The objective is to calculate the minimum number of moves that the knight must make to reach a specific square [x, y] on the chessboard.

A knight in chess moves in an L-shape: 
it can move two squares in one direction (either horizontally or vertically)
 and then make a 90-degree turn to move one square in a perpendicular direction.
  This gives the knight a total of eight possible moves at any given point.

The problem requires us to determine the least number of moves 
necessary to get the knight from its starting position [0, 0] to any target coordinates [x, y]. 
The question assures that it is always possible to reach the target square.
 *
 */

import java.util.*;
public class MinimumKnightMovesLeetCode1197 {

	public static void main(String[] args) {
		MinimumKnightMovesLeetCode1197 solution = new MinimumKnightMovesLeetCode1197();

        // Example 1: x = 2, y = 1
        int x1 = 2;
        int y1 = 1;
        System.out.println("Target: (" + x1 + ", " + y1 + ")");
        System.out.println("Minimum moves: " + solution.minKnightMoves(x1, y1)); // Expected: 1
        System.out.println("--------------------");

        // Example 2: x = 5, y = 5
        int x2 = 5;
        int y2 = 5;
        System.out.println("Target: (" + x2 + ", " + y2 + ")");
        System.out.println("Minimum moves: " + solution.minKnightMoves(x2, y2)); // Expected: 4
        System.out.println("--------------------");
        
        // Example 3: x = 0, y = 0
        int x3 = 0;
        int y3 = 0;
        System.out.println("Target: (" + x3 + ", " + y3 + ")");
        System.out.println("Minimum moves: " + solution.minKnightMoves(x3, y3)); // Expected: 0
        System.out.println("--------------------");

        // Example 4: x = 1, y = 1
        int x4 = 1;
        int y4 = 1;
        System.out.println("Target: (" + x4 + ", " + y4 + ")");
        System.out.println("Minimum moves: " + solution.minKnightMoves(x4, y4)); // Expected: 2
        System.out.println("--------------------");

        // Example 5: x = 0, y = 2
        int x5 = 0;
        int y5 = 2;
        System.out.println("Target: (" + x5 + ", " + y5 + ")");
        System.out.println("Minimum moves: " + solution.minKnightMoves(x5, y5)); // Expected: 2
        System.out.println("--------------------");
    }
	
	 public int minKnightMoves(int x, int y) {
	        // Offset coordinates by 310 to deal with negative indices since a knight can move backward.
	        x += 310;
	        y += 310;

	        // Starting moves count from (0, 0) which is at the center after offset
	        int moves = 0;

	        // Initialize queue for BFS and add starting position after offset
	        Queue<int[]> queue = new ArrayDeque<>();
	        queue.offer(new int[] {310, 310});

	        // Visited matrix to keep track of already visited points.
	        boolean[][] visited = new boolean[621][621];
	        visited[310][310] = true;

	        // Directions a knight can move: 8 possibilities
	        int[][] directions = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};

	        while (!queue.isEmpty()) {
	            // Number of elements in the current level
	            for (int i = queue.size(); i > 0; --i) {
	                // Poll the first element in the queue
	                int[] point = queue.poll();

	                // Check if the current position is the target position
	                if (point[0] == x && point[1] == y) {
	                    return moves;
	                }

	                // Explore all possible moves from the current position
	                for (int[] direction : directions) {
	                    int nextX = point[0] + direction[0];
	                    int nextY = point[1] + direction[1];

	                    // Make sure the new position is within bounds and hasn't been visited
	                    if (nextX >= 0 && nextY >= 0 && nextX < visited.length && nextY < visited[nextX].length && !visited[nextX][nextY]) {
	                        visited[nextX][nextY] = true;
	                        queue.offer(new int[] {nextX, nextY});
	                    }
	                }
	            }
	            // Increment moves after finishing all moves of the current level
	            ++moves;
	        }
	        // Return -1 if we never reach the destination position (should not happen with correct logic)
	        return -1;
	    }

}
