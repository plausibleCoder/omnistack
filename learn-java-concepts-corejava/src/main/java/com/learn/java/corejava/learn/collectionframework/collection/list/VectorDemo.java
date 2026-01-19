package com.learn.java.corejava.learn.collectionframework.collection.list;

import java.util.Vector;

public class VectorDemo {
    /*
    Vector is a legacy class that implements List.
    It is similar to ArrayList but is synchronized, making it thread-safe.
    Because of its synchronization overhead, it is generally slower than ArrayList.
    It is recommended to use ArrayList unless thread-safety is required.
    */
	
	
    public static void main(String[] args) {
        System.out.println("--- Demonstrating the Vector class ---");

        Vector<String> vector = new Vector<>();

        // 1. Adding elements
        vector.add("Element 1");
        vector.add("Element 2");
        vector.addElement("Element 3"); // Legacy method
        System.out.println("Initial Vector: " + vector);

        // 2. Accessing and removing
        System.out.println("First element (legacy): " + vector.firstElement());
        System.out.println("Last element (legacy): " + vector.lastElement());
        vector.remove(0);
        System.out.println("Vector after removing first element: " + vector);
    }
}
