package com.learn.java.corejava.learn.collectionframework.map;

import java.util.Hashtable;

public class HashTableDemo {
    /*
    Hashtable is a legacy class that implements Map.
    It is synchronized, making it thread-safe.
    It does not allow null keys or null values.
    Like Vector, it is generally slower than HashMap due to synchronization.
    For modern code, use ConcurrentHashMap for a thread-safe map.
    */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating the Hashtable class ---");
        
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // 1. Adding elements
        hashtable.put("A", 100);
        hashtable.put("B", 200);
        hashtable.put("C", 300);
        System.out.println("Initial Hashtable: " + hashtable);

        // 2. Getting and removing elements
        System.out.println("Value for 'B': " + hashtable.get("B"));
        hashtable.remove("C");
        System.out.println("Hashtable after removing 'C': " + hashtable);
        
        // 3. Attempting to add null (will throw NullPointerException)
        try {
            hashtable.put(null, 500);
        } catch (NullPointerException e) {
            System.out.println("Caught expected exception: " + e);
        }
        
        try {
            hashtable.put("D", null);
        } catch (NullPointerException e) {
            System.out.println("Caught expected exception: " + e);
        }
    }
}
