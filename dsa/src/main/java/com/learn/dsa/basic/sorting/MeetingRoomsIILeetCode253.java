package com.learn.dsa.basic.sorting;

import java.util.*;

/**
 * July 13 2025
 * Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], 
 * return the minimum number of conference rooms required.

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106
 */
public class MeetingRoomsIILeetCode253 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arr={{0,30},{5,10},{15,20}};
		System.out.println(minMeetingRooms(arr));
		

	}
	
	public static int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i=0; i<intervals.length; i++) 
        {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int rooms = 0;
        int endsItr = 0;
        for(int i=0; i<starts.length; i++) 
        {
            if(starts[i]<ends[endsItr])
                rooms++;
            else
                endsItr++;
        }
        return rooms;
    }
	
	public static int minMeetingRoomsApproach2(int[][] intervals) {
		// sort the start time and sort the end time seperately and use it 
		
		return 0;
		
	}

}
