package com.learn.dsa.basic.arrays;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class LinearSearch {
    public static void main(String[] args) {
        // Test cases: array = {5, 2, 8, 12, 1}, search for 8, 3
    	
    	int[]arr= {5, 2, 8, 12, 1};
    	int[]arr2= {};
    	int [] arr3=null;
    	System.out.println(linearSearch(arr, 8));
    	System.out.println(linearSearch(arr, 3));
    	System.out.println(linearSearch(arr2, 3));
    	System.out.println(linearSearch(arr3, 3));
    	System.out.println("\n \n");
    	System.out.println(linearSearchInStream(arr, 8));
    	System.out.println(linearSearchInStream(arr, 3));
    	System.out.println(linearSearchInStream(arr2, 3));
    	System.out.println(linearSearchInStream(arr3, 3));
    }

    private static boolean linearSearch(int[] arr, int target) {
    	if(arr==null || arr.length==0) {
    		return false;
    	}
    	for(int i=0; i<arr.length;i++) {
    		if(arr[i]==target)
    			return true;
    	}
    	
		return false;
    }
    
    private static boolean linearSearchInStream(int[] arr, int target) {
    	
    	return arr != null && Arrays.stream(arr).anyMatch(x-> Objects.equals(x, target));
    }
}