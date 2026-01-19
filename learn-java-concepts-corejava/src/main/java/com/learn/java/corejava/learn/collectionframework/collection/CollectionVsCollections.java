package com.learn.java.corejava.learn.collectionframework.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionVsCollections {
    public static void main(String[] args) {
        // 'Collection' interface is implemented by List
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        
        System.out.println("Collection (List) after adding elements: " + fruits);
        
        // 'Collections' is a utility class with static methods
        // Sort the list using the static sort() method from the Collections class
        Collections.sort(fruits);
        System.out.println("Collection (List) after sorting with Collections.sort(): " + fruits);
        
        // Use other Collections utility methods
        Collections.reverse(fruits);
        System.out.println("Collection (List) after reversing with Collections.reverse(): " + fruits);
    }
}
