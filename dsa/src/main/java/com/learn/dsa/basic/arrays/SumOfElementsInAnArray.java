package com.learn.dsa.basic.arrays;

import java.util.Arrays;

public class SumOfElementsInAnArray {
	
		public static void main(String[] args) {
			
			int[] arr= {23,45,78,1, -2, 56};
			int sum=0;
			for(int i =0;i<arr.length;i++) {
				sum += arr[i];
			}
			System.out.println(sum);
			sumOfElementsInAnArrayUsingStreams();
		}
		
		public static void sumOfElementsInAnArrayUsingStreams() {
			
			int[] arr= {23,45,78,1, -2, 56};
			System.out.println(Arrays.stream(arr).sum());
			
			
		}
}
