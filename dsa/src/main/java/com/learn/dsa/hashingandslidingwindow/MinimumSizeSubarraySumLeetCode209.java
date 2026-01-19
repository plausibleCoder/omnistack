package com.learn.dsa.hashingandslidingwindow;
import java.util.*;
/**
 * Given an array of positive integers nums and a positive integer target, 
 * return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 

Constraints:

1 <= target <= 109
1 <= nums.length <= 105
1 <= nums[i] <= 104
 

Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
public class MinimumSizeSubarraySumLeetCode209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println(minSubArrayLen(7, new int[] {2,3,1,2,4,3} ));
		System.out.println(minSubArrayLen(4, new int[] {1,4,4} ));
		System.out.println(minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1} ));
		

	}
    // This method finds the minimum length of a subarray that sums to at least the given target.
    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length; // The length of the input array.
        long sum = 0; // The sum of the current subarray.
        int minLength = n + 1; // Initialize minLength with max possible value plus one for comparison.

        // Two pointers method: i is the end-pointer, j is the start-pointer of the sliding window.
        for (int end = 0, start = 0; end < n; ++end) {
            sum += nums[end]; // Increment the sum by the current element value.
          
            // Shrink the window from the left until the sum is smaller than the target.
            // This finds the smallest window that ends at position 'end'.
            while (start < n && sum >= target) {
                minLength = Math.min(minLength, end - start + 1); // Update minLength if a smaller length is found.
                sum -= nums[start++]; // Decrease the sum by the start-value and increment start-pointer to shrink the window.
            }
        }

        // If minLength is updated (smaller than n + 1), we found a valid subarray.
        // Otherwise, return 0 as a subarray meeting the conditions is not found.
        return minLength <= n ? minLength : 0;
    }

}
