package com.learn.java.corejava.learn.collectionframework.collection.queue.deque;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeDemo {
    /*
    The Deque (Double-Ended Queue) interface extends the Queue interface.
    It represents a queue where elements can be added or removed from both ends.
    It can be used as a traditional FIFO queue or a LIFO stack.
    The ArrayDeque class is a common, efficient, non-thread-safe implementation.
    */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating the Deque interface with ArrayDeque ---");
        
        Deque<String> stackDeque = new ArrayDeque<>();

        // 1. Using Deque as a LIFO Stack
        System.out.println("\nUsing ArrayDeque as a LIFO Stack:");
        stackDeque.push("Stack Item 1");
        stackDeque.push("Stack Item 2");
        stackDeque.push("Stack Item 3");
        System.out.println("Stack-like Deque: " + stackDeque);
        System.out.println("Popped (removed) item: " + stackDeque.pop());
        System.out.println("Stack-like Deque after pop: " + stackDeque);
        
        // 2. Using Deque as a FIFO Queue
        System.out.println("\nUsing ArrayDeque as a FIFO Queue:");
        Deque<String> queueDeque = new ArrayDeque<>();
        queueDeque.offer("Queue Item A");
        queueDeque.offer("Queue Item B");
        queueDeque.offer("Queue Item C");
        System.out.println("Queue-like Deque: " + queueDeque);
        System.out.println("Polled (removed) item: " + queueDeque.poll());
        System.out.println("Queue-like Deque after poll: " + queueDeque);
    }
}
