package com.learn.java.corejava.learn.collectionframework.collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {
    /*
    The PriorityQueue class implements the Queue interface.
    It processes elements based on their priority, not their insertion order (FIFO).
    By default, it uses the natural ordering of elements (e.g., numerical order for integers)
    to determine priority (smallest element has the highest priority).
    It is not thread-safe.
    */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating the PriorityQueue class ---");
        
        Queue<Integer> numberPriorityQueue = new PriorityQueue<>();

        // 1. Adding elements
        // The queue will automatically sort them based on natural ordering
        numberPriorityQueue.offer(10);
        numberPriorityQueue.offer(5);
        numberPriorityQueue.offer(20);
        numberPriorityQueue.offer(1);
        System.out.println("Initial PriorityQueue: " + numberPriorityQueue); // Internal order is not guaranteed for printing
       /* Initial PriorityQueue: [1, 5, 20, 10]
        		offer(10): PriorityQueue adds 10. The queue looks like [10].
        		offer(5): 5 is added and bubbles up, becoming the new 
	        		root because it has a higher priority (lower value). 
	        		The queue becomes [5, 10].
        		offer(20): 20 is added. The queue becomes [5, 10, 20].
        		offer(1): 1 is added and bubbles up to the root. 
	        		The queue becomes [1, 5, 20, 10]. 
	        		This is a valid heap structure, but not a sorted array.
        */
        
        
        
        // 2. Polling elements (retrieves and removes head)
        // Note that it always retrieves the highest priority element (smallest in this case).
        System.out.println("Polling (highest priority): " + numberPriorityQueue.poll());
        System.out.println("Queue after first poll: " + numberPriorityQueue);

        System.out.println("Polling again: " + numberPriorityQueue.poll());
        System.out.println("Queue after second poll: " + numberPriorityQueue);
        
        // 3. Peeking at the head
        System.out.println("Peeking at the next highest priority element: " + numberPriorityQueue.peek());
        System.out.println("Queue after peeking: " + numberPriorityQueue);
    }
}
