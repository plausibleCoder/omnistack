package com.learn.java.corejava.learn.collectionframework.map;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {
    /*
    The SortedMap interface extends Map.
    It stores key-value pairs sorted by their keys, either naturally or by a specified Comparator.
    The TreeMap class is the most common implementation.
    It provides additional methods for accessing first/last keys and subsets.
    */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating the SortedMap interface with TreeMap ---");
        
        SortedMap<Integer, String> sortedMap = new TreeMap<>();

        // 1. Adding elements
        sortedMap.put(5, "Five");
        sortedMap.put(2, "Two");
        sortedMap.put(8, "Eight");
        sortedMap.put(1, "One");
        sortedMap.put(2, "Another Two"); // Replaces value for key 2
        System.out.println("SortedMap (TreeMap): " + sortedMap); // Sorted by keys

        // 2. Accessing first and last keys
        System.out.println("First key: " + sortedMap.firstKey());
        System.out.println("Last key: " + sortedMap.lastKey());
        
        // 3. Submaps (portions of the map)
        SortedMap<Integer, String> headMap = sortedMap.headMap(5); // Entries with keys < 5
        System.out.println("HeadMap (keys < 5): " + headMap);
        
        SortedMap<Integer, String> tailMap = sortedMap.tailMap(5); // Entries with keys >= 5
        System.out.println("TailMap (keys >= 5): " + tailMap);
        
        SortedMap<Integer, String> subMap = sortedMap.subMap(2, 8); // Entries with keys >= 2 and < 8
        System.out.println("SubMap (keys >= 2 and < 8): " + subMap);
    }
}
