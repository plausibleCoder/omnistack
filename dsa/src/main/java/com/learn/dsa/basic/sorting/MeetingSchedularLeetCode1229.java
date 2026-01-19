package com.learn.dsa.basic.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * July 13th 2025
 * 
 * Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, 
 * return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

It is guaranteed that no two availability slots of the same person intersect with each other. 
That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []
 
 */
public class MeetingSchedularLeetCode1229 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][]slots1 = {{10,50},{60,120},{140,210}}; 
		int[][]	slots2 = {{0,15},{60,70}};
		int duration=8;
		System.out.println(minAvailableDuration(slots1, slots2, duration));

	}
	
	public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        int m = slots1.length, n = slots2.length;
        int i = 0, j = 0;
        while (i < m && j < n) {
            int start = Math.max(slots1[i][0], slots2[j][0]);
            int end = Math.min(slots1[i][1], slots2[j][1]);
            if (end - start >= duration) {
                return Arrays.asList(start, start + duration);
            }
            if (slots1[i][1] < slots2[j][1]) {
                ++i;
            } else {
                ++j;
            }
        }
        return Collections.emptyList();
    }

}
