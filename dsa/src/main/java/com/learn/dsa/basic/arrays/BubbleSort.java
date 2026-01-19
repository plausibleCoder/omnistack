package com.learn.dsa.basic.arrays;

public class BubbleSort {
	public static void main(String[] args) {
		// Test case: {64, 34, 25, 12, 22}
		int[] arr = { 64, 34, 25, 12, 22 };
		bubbleSort(arr);
		// Print sorted array
		for (int num : arr) {
			System.out.print(num + " ");
		}
	}

	private static void bubbleSort(int[] arr) {
		for (int j = 0; j < arr.length; j++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
					i++;
				}
			}
				
		}
	}
}

//34 64 12 25 22 