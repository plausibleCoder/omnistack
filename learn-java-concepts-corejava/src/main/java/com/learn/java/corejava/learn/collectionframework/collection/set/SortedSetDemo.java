package com.learn.java.corejava.learn.collectionframework.collection.set;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetDemo {
    /*
    The SortedSet interface extends Set.
    It stores elements in a sorted order, either natural ordering or by a specified Comparator.
    The TreeSet class is the most common implementation.
    It provides additional methods for accessing first/last elements and subsets.
    */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating the SortedSet interface with TreeSet ---");
        
        SortedSet<Integer> sortedSet = new TreeSet<>();

        // 1. Adding elements
        sortedSet.add(5);
        sortedSet.add(2);
        sortedSet.add(8);
        sortedSet.add(2); // Duplicate, will be ignored
        sortedSet.add(1);
        System.out.println("SortedSet (TreeSet): " + sortedSet); // Elements are automatically sorted

        // 2. Accessing first and last elements
        System.out.println("First element: " + sortedSet.first());
        System.out.println("Last element: " + sortedSet.last());
        
        // 3. Subsets (portions of the set)
        SortedSet<Integer> headSet = sortedSet.headSet(5); // Elements < 5
        System.out.println("HeadSet (elements < 5): " + headSet);
        
        SortedSet<Integer> tailSet = sortedSet.tailSet(5); // Elements >= 5
        System.out.println("TailSet (elements >= 5): " + tailSet);
        
        SortedSet<Integer> subSet = sortedSet.subSet(2, 8); // Elements >= 2 and < 8
        System.out.println("SubSet (elements >= 2 and < 8): " + subSet);
    }
}
