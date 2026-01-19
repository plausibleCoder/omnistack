package com.learn.java.corejava.learn.collectionframework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Collection;

public class CollectionVsCollections {

    public static void main(String[] args) {
        // --- Collection Interface Example ---
        // 'Collection' is an interface, defining basic methods for all collection types.
        System.out.println("--- The 'Collection' Interface ---");
        // Cannot be instantiated directly; must use a concrete class.
        Collection<String> myCollection = new ArrayList<>();
        myCollection.add("A");
        myCollection.add("B");
        myCollection.add("C");
        System.out.println("My Collection: " + myCollection);
        System.out.println("Is the collection empty? " + myCollection.isEmpty());
        System.out.println("Size of the collection: " + myCollection.size());
        myCollection.remove("B");
        System.out.println("Collection after removing 'B': " + myCollection);

        // --- Collections Utility Class Example ---
        // 'Collections' is a utility class providing static methods to operate on collections.
        System.out.println("\n--- The 'Collections' Utility Class ---");
        List<String> fruits = new ArrayList<>();
        fruits.add("Orange");
        fruits.add("Apple");
        fruits.add("Banana");

        System.out.println("Original List: " + fruits);
        
        // Sorting the list using Collections.sort()
        Collections.sort(fruits);
        System.out.println("Sorted List (Collections.sort()): " + fruits);

        // Reversing the list
        Collections.reverse(fruits);
        System.out.println("Reversed List (Collections.reverse()): " + fruits);
        
        // Shuffling the list
        Collections.shuffle(fruits);
        System.out.println("Shuffled List (Collections.shuffle()): " + fruits);
        
        // Finding max/min elements
        System.out.println("Maximum element: " + Collections.max(fruits));
        System.out.println("Minimum element: " + Collections.min(fruits));
    }
}
