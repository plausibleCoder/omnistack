package com.learn.java.corejava.learn.collectionframework;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableDemo {
    /*
    The Iterable interface is the root of the Collection hierarchy.
    It allows an object to be the target of the enhanced for-each loop.
    It has a single abstract method: iterator(), which returns an Iterator object.
    You can use the Iterator to traverse and, optionally, remove elements from the collection.
    */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating the Iterable interface ---");

        // We use a List, which is an Iterable, to demonstrate
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        
        System.out.println("1. Iterating using the enhanced for-each loop:");
        for (String fruit : fruits) {
            System.out.println("Fruit: " + fruit);
        }

        System.out.println("\n2. Iterating using an explicit Iterator:");
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Processing: " + fruit);
            // Example of using Iterator's optional remove() method
            if (fruit.equals("Banana")) {
                iterator.remove();
                System.out.println("  - Removed Banana");
            }
        }
        System.out.println("List after removing 'Banana': " + fruits);
    }
}
