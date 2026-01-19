package com.learn.dsa.basic.slidingwindow;
/*
Problem Statement: Given an array of integers and a number \(k\), find the maximum sum of any contiguous subarray of size exactly \(k\). Example: Input: arr = [2, 1, 5, 1, 3, 2], k = 3
output: 9
Explanation: Subarrays are [2,1,5] (sum 8), [1,5,1] (sum 7), [5,1,3] 
(sum 9), and [1,3,2] (sum 6). The maximum is 9. 
*/

public class SlidingWindowBasic {
    public static void main(String[] args){

        System.out.println(basicSlidingWindowProblem(new int[] {2, 1, 5, 1, 3, 2},3));
        System.out.println(efficientSlidingWindowproblem(new int[] {2, 1, 5, 1, 3, 2},3));

    }

    static int efficientSlidingWindowproblem(int[] arr, int k){
        int windowStart =0;
        int windowEnd =0;
        int output=0;
        int windowSum=0;

        for(windowEnd=0; windowEnd<arr.length; windowEnd++){

          windowSum =  windowSum+arr[windowEnd];
          if(windowEnd >= k-1){
            output= Math.max(output, windowSum);
            windowSum =  windowSum-arr[windowStart];
            windowStart++;
          }

        }

        return output;
    }
    static int basicSlidingWindowProblem(int [] arr, int k){
                int windowStart=0;
        int output=0;
        while(true){
        int sum=0;

        for(int i=windowStart;i<windowStart+k;i++){
            sum=sum+arr[i];
        }
        if(sum>output){
            output=sum;
        }
        if(windowStart+k==arr.length){
            return output;
        }
        windowStart++;
    }


    }
    
}
