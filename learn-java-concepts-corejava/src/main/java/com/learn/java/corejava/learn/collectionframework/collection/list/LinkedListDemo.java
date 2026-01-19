package com.learn.java.corejava.learn.collectionframework.collection.list;

import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {
    /*
     * LinkedList: A doubly-linked list implementation of the List and Deque interfaces.
     * Unlike ArrayList, it is not based on an array, but on a series of nodes, each
     * with a pointer to the next and previous node.
     *
     * Key Characteristics:
     * - Fast insertion and deletion operations, especially at the ends.
     * - Slower random access (retrieving an element by index) because it must
     *   traverse the list from the beginning or end.
     * - Can function as a List, a Queue (FIFO), or a Stack (LIFO).
     * - Not synchronized (not thread-safe).
     */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating LinkedList as a List ---");
        List<String> linkedList = new LinkedList<>();

        // 1. Adding elements to the list
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        System.out.println("Initial LinkedList: " + linkedList);

        // 2. Index-based insertion (relatively slower than ArrayList)
        linkedList.add(1, "Grape");
        System.out.println("LinkedList after adding at index 1: " + linkedList);

        // 3. Random access (get by index)
        System.out.println("Element at index 2: " + linkedList.get(2));

        // 4. Index-based removal (relatively slower than ArrayList)
        linkedList.remove(0);
        System.out.println("LinkedList after removing at index 0: " + linkedList);

        System.out.println("\n--- Demonstrating LinkedList as a Queue (FIFO) ---");
        LinkedList<String> queueList = (LinkedList<String>) linkedList;

        // Add to the tail using Queue methods
        queueList.offer("Fig");
        System.out.println("Queue-like LinkedList: " + queueList);

        // Remove from the head using Queue methods
        System.out.println("Polled from head: " + queueList.poll());
        System.out.println("Queue-like LinkedList after poll: " + queueList);

        System.out.println("\n--- Demonstrating LinkedList as a Stack (LIFO) ---");
        LinkedList<String> stackList = (LinkedList<String>) linkedList;

        // Push to the head using Stack methods
        stackList.push("Top of Stack");
        System.out.println("Stack-like LinkedList: " + stackList);

        // Pop from the head using Stack methods
        System.out.println("Popped from head: " + stackList.pop());
        System.out.println("Stack-like LinkedList after pop: " + stackList);
    }
}
