package com.learn.dsa.basic.slidingwindow;
/*
New Problem: Smallest Subarray with a Sum ≥ S
The Goal: Given an array of positive integers and a positive number S, find the length of the smallest contiguous subarray whose sum is greater than or equal to S. If no such subarray exists, return 0.

Example:

Array: [2, 1, 5, 2, 3, 2]

S: 7

The Question: What is the length of the smallest subarray that adds up to at least 7?

Looking at the array:

[2, 1, 5] has a sum of 8. The length is 3.

[5, 2] has a sum of 7. The length is 2.

[5, 2, 3] has a sum of 10. The length is 3.

[2, 3, 2] has a sum of 7. The length is 3.

The smallest length here is 2.
*/
public class SmallestSubarrayWithASum {
    public static void main(String[] args){
        int[] arr = {2, 1, 5, 2, 3, 2, 7};
        int s = 7;
        System.out.println(smallestLengthMine(arr, s));
    }

    static int smallestLength(int [] arr, int s ){
        int smallestLength =0;
        int windowStart=0;
        int windowEnd=0;
        int windowSum=0;
        int windowLength=0;

        for(windowEnd=0; windowEnd <=arr.length-1; windowEnd++){
            windowSum = windowSum+arr[windowEnd];
            if(windowSum > s){
                windowSum=windowSum-arr[windowStart];
                smallestLength=Math.min(windowLength, windowStart);
                windowStart++;
            }
            else if (windowSum==s){
                windowLength = windowStart-windowEnd;
                if(smallestLength!=0){
                 smallestLength=Math.min(smallestLength, windowLength);
                }

            }

        }


        return smallestLength;
    }

   public static int smallestSubarrayWithSum(int[] arr, int s) {
    int minLength = Integer.MAX_VALUE; // <-- Fix #1: Initialize to a large value
    int windowSum = 0;
    int windowStart = 0;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        // Expand the window by adding the element from the right
        windowSum += arr[windowEnd];

        // This is the key!
        // Keep shrinking the window from the left as long as the sum is >= s
        while (windowSum >= s) { // <-- Fix #2: Use a 'while' loop, not 'if'
            // We have a valid window. Is it the smallest we've seen?
            minLength = Math.min(minLength, windowEnd - windowStart + 1);

            // Shrink the window
            windowSum -= arr[windowStart];
            windowStart++;
        }
    }

    // If minLength was never updated, it means no valid subarray was found.
    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}

}
