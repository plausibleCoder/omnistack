package com.learn.dsa.basic.heaps;

import java.util.*;
/**
 * 
 * 17th July 2025
 * Median : Average
 * Mode : Frequency 
 * The median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value, 
 * and the median is the mean of the two middle values.

For example, for arr = [2,3,4], the median is 3.
For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
Implement the MedianFinder class:

MedianFinder() initializes the MedianFinder object.
void addNum(int num) adds the integer num from the data stream to the data structure.
double findMedian() returns the median of all elements so far. Answers within 10-5 of the actual answer will be accepted.
 

Example 1:

Input
["MedianFinder", "addNum", "addNum", "findMedian", "addNum", "findMedian"]
[[], [1], [2], [], [3], []]
Output
[null, null, null, 1.5, null, 2.0]

Explanation
MedianFinder medianFinder = new MedianFinder();
medianFinder.addNum(1);    // arr = [1]
medianFinder.addNum(2);    // arr = [1, 2]
medianFinder.findMedian(); // return 1.5 (i.e., (1 + 2) / 2)
medianFinder.addNum(3);    // arr[1, 2, 3]
medianFinder.findMedian(); // return 2.0
 

Constraints:

-105 <= num <= 105
There will be at least one element in the data structure before calling findMedian.
At most 5 * 104 calls will be made to addNum and findMedian.
 

Follow up:

If all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
If 99% of all integer numbers from the stream are in the range [0, 100], how would you optimize your solution?
 * 
 */
public class MedianFromDataStreamLeetCode295 {
	

	    // max heap to store the smaller half of the numbers
	    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

	    // min heap to store the larger half of the numbers
	    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

	    public MedianFromDataStreamLeetCode295() {
	        // Constructor
	    }

	    public void addNum(int num) {
	        maxHeap.add(num); // Add to the maxHeap (smaller half) first

	        // Balance and order: maxHeap's top <= minHeap's top
	        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
	            minHeap.add(maxHeap.poll());
	        }

	        // Balance the heap sizes: maxHeap should have at most one more element than minHeap
	        if (maxHeap.size() > minHeap.size() + 1) {
	            minHeap.add(maxHeap.poll());
	        } else if (minHeap.size() > maxHeap.size()) {
	            maxHeap.add(minHeap.poll());
	        }
	    }

	    public double findMedian() {
	        if (maxHeap.size() == minHeap.size()) { // Even number of elements
	            return (double) (maxHeap.peek() + minHeap.peek()) / 2.0;
	        } else { // Odd number of elements
	            return (double) maxHeap.peek();
	        }
	    }

	    public static void main(String[] args) {
	    	MedianFromDataStreamLeetCode295 medianFinder = new MedianFromDataStreamLeetCode295();

	        // Test Case 1
	        System.out.println("Test Case 1:");
	        medianFinder.addNum(1); // arr = [1]
	        medianFinder.addNum(2); // arr = [1, 2]
	        System.out.println(medianFinder.findMedian()); // Expected: 1.5
	        medianFinder.addNum(3); // arr = [1, 2, 3]
	        System.out.println(medianFinder.findMedian()); // Expected: 2.0

	        System.out.println("\nTest Case 2:");
	        // Test Case 2 (resetting for this new set of inputs)
	        medianFinder = new MedianFromDataStreamLeetCode295(); // Creates a new MedianFinder object

	        medianFinder.addNum(6);
	        System.out.println(medianFinder.findMedian()); // Expected: 6.0
	        medianFinder.addNum(10);
	        System.out.println(medianFinder.findMedian()); // Expected: 8.0
	        medianFinder.addNum(2);
	        System.out.println(medianFinder.findMedian()); // Expected: 6.0
	        medianFinder.addNum(6);
	        System.out.println(medianFinder.findMedian()); // Expected: 6.0
	        medianFinder.addNum(5);
	        System.out.println(medianFinder.findMedian()); // Expected: 6.0
	        medianFinder.addNum(0);
	        System.out.println(medianFinder.findMedian()); // Expected: 5.5
	        medianFinder.addNum(6);
	        System.out.println(medianFinder.findMedian()); // Expected: 6.0
	        medianFinder.addNum(3);
	        System.out.println(medianFinder.findMedian()); // Expected: 5.5
	        medianFinder.addNum(1);
	        System.out.println(medianFinder.findMedian()); // Expected: 5.0
	        medianFinder.addNum(0);
	        System.out.println(medianFinder.findMedian()); // Expected: 4.0
	        medianFinder.addNum(0);
	        System.out.println(medianFinder.findMedian()); // Expected: 3.0
	    }
	}
