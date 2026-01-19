package com.learn.dsa.dynamicprogramming;

import java.util.Arrays;

/**
 * 
 * @author karthik
 You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step
 */
public class ClimbingStairsLeetCode70 {
	
	 private int[] memo;

	    /**
	     * Entry point for the climbing stairs problem using memoization.
	     * This method initializes the memoization array and calls the recursive helper.
	     *
	     * @param n The number of steps to reach the top.
	     * @return The number of distinct ways to climb to the top.
	     */
	    public int climbStairs(int n) {
	        if (n <= 0) {
	            return 0;
	        }
	        memo = new int[n + 1];
	        Arrays.fill(memo, -1); // Initialize memo array with a value indicating not computed yet
	        return climb(n);
	    }

	    /**
	     * Recursive helper function with memoization.
	     *
	     * @param n The number of remaining steps.
	     * @return The number of ways to climb the remaining steps.
	     */
	    private int climb(int n) {
	        // Base cases
	        if (n == 0) {
	            return 1; // Reached the top, this is one valid way
	        }
	        if (n < 0) {
	            return 0; // Overshot the top, this is not a valid way
	        }

	        // Check if the result for this subproblem is already computed
	        if (memo[n] != -1) {
	            return memo[n];
	        }

	        // Recursive step: The number of ways to reach step n is the sum of
	        // ways to reach step n-1 and step n-2.
	        memo[n] = climb(n - 1) + climb(n - 2);

	        return memo[n];
	    }
	}