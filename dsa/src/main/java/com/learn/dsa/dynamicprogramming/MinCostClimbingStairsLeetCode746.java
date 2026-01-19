package com.learn.dsa.dynamicprogramming;

import java.util.Arrays;

/*
 You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: You will start at index 0.
- Pay 1 and climb two steps to reach index 2.
- Pay 1 and climb two steps to reach index 4.
- Pay 1 and climb two steps to reach index 6.
- Pay 1 and climb one step to reach index 7.
- Pay 1 and climb two steps to reach index 9.
- Pay 1 and climb one step to reach the top.
The total cost is 6.
 */
public class MinCostClimbingStairsLeetCode746 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	    // Memoization array to store the minimum cost to reach each step.
	    private int[] memo;
	    private int[] cost;

	    /**
	     * Entry point for the minimum cost climbing stairs problem using memoization.
	     * Initializes the memoization array and calls the recursive helper.
	     *
	     * @param cost The array of costs for each step.
	     * @return The minimum cost to reach the top.
	     */
	    public int minCostClimbingStairs(int[] cost) {
	        int n = cost.length;
	        this.cost = cost;
	        memo = new int[n + 1];
	        Arrays.fill(memo, -1);

	        return Math.min(getMinCost(n - 1), getMinCost(n - 2));
	    }

	    /**
	     * Recursive helper function with memoization.
	     * Calculates the minimum cost to reach step i.
	     *
	     * @param i The current step index.
	     * @return The minimum cost to reach step i.
	     */
	    private int getMinCost(int i) {
	        if (i < 0) {
	            return 0;
	        }
	        if (i == 0 || i == 1) {
	            return cost[i];
	        }

	        if (memo[i] != -1) {
	            return memo[i];
	        }

	        memo[i] = cost[i] + Math.min(getMinCost(i - 1), getMinCost(i - 2));

	        return memo[i];
	    }
	}
