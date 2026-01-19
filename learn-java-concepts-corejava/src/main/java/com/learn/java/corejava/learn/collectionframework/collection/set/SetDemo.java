package com.learn.java.corejava.learn.collectionframework.collection.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo {
    /*
    The Set interface extends Collection.
    It represents a collection that contains no duplicate elements.
    It does not guarantee the order of its elements.
    Common implementations are HashSet, LinkedHashSet, and TreeSet.
    */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating the Set interface ---");

        // 1. HashSet Demo (no order guarantee, fast access)
        System.out.println("\n--- HashSet: Unordered, fast access ---");
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Apple"); // Adding a duplicate, which is ignored
        hashSet.add("Cherry");
        System.out.println("HashSet: " + hashSet); // Order is not guaranteed

        // 2. LinkedHashSet Demo (maintains insertion order)
        System.out.println("\n--- LinkedHashSet: Maintains insertion order ---");
        Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Apple");
        linkedHashSet.add("Cherry");
        System.out.println("LinkedHashSet: " + linkedHashSet); // Order is preserved

        // 3. Common Set operations
        System.out.println("\n--- Common Set Operations ---");
        System.out.println("Size of HashSet: " + hashSet.size());
        System.out.println("Does HashSet contain 'Banana'? " + hashSet.contains("Banana"));
        hashSet.remove("Apple");
        System.out.println("HashSet after removing 'Apple': " + hashSet);
    }
}
