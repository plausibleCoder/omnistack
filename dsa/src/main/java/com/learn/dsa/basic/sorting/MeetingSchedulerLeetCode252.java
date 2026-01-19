package com.learn.dsa.basic.sorting;

import java.util.Arrays;

/**12th July 2025 and 13th july 2025
 * Leetcode number:252
 * 
 * Input intervals =[[0,30],[5,10],[7,9]]
 * 
 * Hint: Do this with Epoch for generic way
 */

public class MeetingSchedulerLeetCode252 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public static boolean util(int arr[][]) {
		Arrays.sort(arr, (a,b)-> Integer.compare(a[0], b[0]));
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i][0]<arr[i-1][1]) return false;
		}
		return true;
	}

	
}
