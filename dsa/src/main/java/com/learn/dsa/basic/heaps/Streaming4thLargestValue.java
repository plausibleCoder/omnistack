package com.learn.dsa.basic.heaps;

import java.util.ArrayList;
import java.util.Arrays; // Needed for Arrays.toString() for printing arrays
import java.util.PriorityQueue;

/*
 * 
 * 17th July 2025
 */

public class Streaming4thLargestValue {

    public static void main(String[] args) {
        // --- Sample Input 1 ---
        int arr1[] = {1, 2, 3, 4, 5, 6};
        int k1 = 4;
        ArrayList<Integer> result1 = streamLargest(arr1, k1);
        System.out.println("Input: arr=" + Arrays.toString(arr1) + ", k=" + k1 + ", Output: " + result1);
        // Expected Output: [-1, -1, -1, 1, 2, 3]

        System.out.println("--------------------");

        // --- Sample Input 2 ---
        int arr2[] = {3, 4};
        int k2 = 1;
        ArrayList<Integer> result2 = streamLargest(arr2, k2);
        System.out.println("Input: arr=" + Arrays.toString(arr2) + ", k=" + k2 + ", Output: " + result2);
        // Expected Output: [3, 4]

        System.out.println("--------------------");

        // --- Sample Input 3 ---
        int arr3[] = {10, 20, 11, 70, 50, 40, 100, 5};
        int k3 = 3;
        ArrayList<Integer> result3 = streamLargest(arr3, k3);
        System.out.println("Input: arr=" + Arrays.toString(arr3) + ", k=" + k3 + ", Output: " + result3);
        // Expected Output: [-1, -1, 10, 11, 20, 40, 50, 50]

        System.out.println("--------------------");

        // --- Another example ---
        int arr4[] = {7, 7, 7, 7, 8, 3};
        int k4 = 4;
        ArrayList<Integer> result4 = streamLargest(arr4, k4);
        System.out.println("Input: arr=" + Arrays.toString(arr4) + ", k=" + k4 + ", Output: " + result4);
        // Expected Output: [-1, -1, -1, 7, 7, 7]

    }
    
    public static ArrayList<Integer> streamLargest(int arr[], int k) {

        PriorityQueue<Integer> q = new PriorityQueue<>(); // This is a min-heap by default
        ArrayList<Integer> res = new ArrayList<>();

        // Add elements to the priority queue and track the k-th largest
        for (int i = 0; i < arr.length; i++) {
            if (q.size() < k) {
                q.add(arr[i]);
            } else if (arr[i] > q.peek()) {
                q.poll(); // Remove the smallest element (k-th largest)
                q.add(arr[i]); // Add the new larger element
            }

            if (q.size() < k) {
                res.add(-1); // Return -1 if fewer than k elements have been inserted
            } else {
                res.add(q.peek()); // Add the current k-th largest to the result list
            }
        }
        return res;
    }

}
