package com.learn.java.corejava.learn.collectionframework.collection.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	/*
	 First-In, First-Out (FIFO): The fundamental concept of a Queue is that the first element added to it is the first one to be removed. Elements are inserted at the back ("rear" or "tail") and removed from the front ("head").
Interface, not class: Queue is an interface in the java.util package, so you cannot create an instance of it directly. Instead, you must use a concrete class that implements the Queue interface, such as LinkedList or ArrayDeque.
No random access: Unlike a List, a Queue does not support random access by index. You can only interact with the elements at the head and tail.

	Common use cases
Queues are ideal for managing items that need to be processed in a specific, sequential order.
Task scheduling: Operating systems and web servers use queues to manage processes and incoming requests.
Producer-Consumer pattern: A Queue acts as a safe buffer between one or more "producer" threads that add data and "consumer" threads that process it. A BlockingQueue is often used for this pattern.
Event handling: Applications use queues to process events in the order they occur.
Breadth-First Search (BFS): This graph traversal algorithm uses a queue to explore nodes level by level.

*/

    public static void main(String[] args) {
        System.out.println("Demonstrating Queue using LinkedList implementation.");
        
        // 1. Creating a Queue object
        // The object is of type LinkedList, but we reference it as a Queue.
        Queue<String> customerQueue = new LinkedList<>();

        // 2. Adding elements to the queue
        // offer(E e): Inserts the specified element into this queue.
        // It's generally preferred over add(E e) because it doesn't throw an exception if the queue is capacity-constrained.
        customerQueue.offer("Alice");
        customerQueue.offer("Bob");
        customerQueue.offer("Charlie");
        System.out.println("Queue after adding elements: " + customerQueue);

        // 3. Inspecting the head of the queue
        // peek(): Retrieves, but does not remove, the head of this queue. Returns null if the queue is empty.
        // element(): Same as peek(), but throws a NoSuchElementException if the queue is empty.
        System.out.println("Head of the queue (using peek()): " + customerQueue.peek());
        System.out.println("Head of the queue (using element()): " + customerQueue.element());
        System.out.println("Queue remains unchanged after peeking: " + customerQueue);

        // 4. Removing elements from the queue
        // poll(): Retrieves and removes the head of this queue. Returns null if the queue is empty.
        // remove(): Same as poll(), but throws a NoSuchElementException if the queue is empty.
        String firstCustomer = customerQueue.poll();
        System.out.println("Removed first customer (using poll()): " + firstCustomer);
        System.out.println("Queue after polling: " + customerQueue);

        String secondCustomer = customerQueue.remove();
        System.out.println("Removed second customer (using remove()): " + secondCustomer);
        System.out.println("Queue after removing: " + customerQueue);

        // 5. Checking the state of the queue
        System.out.println("Is the queue empty? " + customerQueue.isEmpty());

        // 6. Polling from an empty queue
        System.out.println("Polling from an empty queue: " + customerQueue.poll()); // Prints null, does not throw an exception
        System.out.println("Attempting to remove from an empty queue...");
        try {
            customerQueue.remove(); // Throws NoSuchElementException
        } catch (java.util.NoSuchElementException e) {
            System.out.println("Caught expected exception: " + e);
        }

        // 7. Demonstration of other implementations (e.g., PriorityQueue)
        System.out.println("\n--- Demonstrating PriorityQueue ---");
        // A PriorityQueue processes elements based on priority, not FIFO.
        // By default, it uses natural ordering (e.g., numerical order for integers).
        Queue<Integer> numberPriorityQueue = new java.util.PriorityQueue<>();
        numberPriorityQueue.offer(10);
        numberPriorityQueue.offer(5);
        numberPriorityQueue.offer(20);
        numberPriorityQueue.offer(1);
        System.out.println("Initial PriorityQueue: " + numberPriorityQueue); // Internal order is not preserved

        System.out.println("Polling from PriorityQueue (retrieves smallest): " + numberPriorityQueue.poll());
        System.out.println("Polling again: " + numberPriorityQueue.poll());
    }
    
}
