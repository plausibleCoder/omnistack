package com.learn.dsa.basic.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * 12th July 2025
 * 
 * input [7,8,6,3,1,0,4,2,1] tripletSum=19
 * give the triplets which form the tripletSum
 */
public class TripletSumSearch {
	
	public static void main(String[] args) {	
	int arr[] = {7,8,6,3,1,0,4,2,1};
	int tripletSum=19;
	method(arr,tripletSum);
	}
	
	public static void method(int[] arr, int tripletSum) {
		List<List<Integer>> answer = new ArrayList<>();
		List<Integer> list=null;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1; j<arr.length;j++) {
				for(int k=j+1;k<arr.length;k++) {
					if(arr[i]+arr[j]+arr[k]==tripletSum) {
						list = new ArrayList<>();
						list.add(arr[i]);
						list.add(arr[j]);
						list.add(arr[k]);
						System.out.println(list);
					}
				}
			}
		}
		
	}
	
	public static String method2(int[] arr, int targetSum) {
		for(int k=0;k<arr.length;k++) {
		int i=k+1;
		int sum=targetSum -arr[k];
		int j= arr.length-1;
		while(i<j) {
			if(arr[i]+arr[j]==sum) {
				return k+" "+ i+ " "+j;
				
			}
			
			if(arr[i]+arr[j]>sum) {
				j-=1;
			}
			else{
				i+=1;
			}
		}
		}
		return null;
	}

}
