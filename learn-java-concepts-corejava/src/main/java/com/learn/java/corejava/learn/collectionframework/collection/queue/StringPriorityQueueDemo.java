package com.learn.java.corejava.learn.collectionframework.collection.queue;

import java.util.PriorityQueue;
import java.util.Queue;

public class StringPriorityQueueDemo {
    public static void main(String[] args) {
        System.out.println("--- Demonstrating the PriorityQueue with Strings ---");
        
        Queue<String> stringPriorityQueue = new PriorityQueue<>();

        // 1. Adding elements
        stringPriorityQueue.offer("Banana");
        stringPriorityQueue.offer("Apple");
        stringPriorityQueue.offer("Orange");
        stringPriorityQueue.offer("Cherry");
        
        System.out.println("Initial PriorityQueue: " + stringPriorityQueue);

        // 2. Polling elements (retrieves and removes head)
        System.out.println("Polling (highest priority): " + stringPriorityQueue.poll());
        System.out.println("Queue after first poll: " + stringPriorityQueue);

        System.out.println("Polling again: " + stringPriorityQueue.poll());
        System.out.println("Queue after second poll: " + stringPriorityQueue);
        
        // 3. Peeking at the head
        System.out.println("Peeking at the next highest priority element: " + stringPriorityQueue.peek());
        System.out.println("Queue after peeking: " + stringPriorityQueue);
    }
}
