package com.learn.java.corejava.learn.collectionframework.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class MapDemo {

    public static void main(String[] args) {
        // --- HashMap: Unordered, fast key-based access ---
        System.out.println("--- HashMap Demonstration ---");
        Map<String, String> contactList = new HashMap<>();
        contactList.put("Alice", "123-456-7890");
        contactList.put("Bob", "987-654-3210");
        contactList.put("Charlie", "555-111-2222");
        System.out.println("HashMap: " + contactList);
        System.out.println("Bob's number: " + contactList.get("Bob"));

        // Replacing a value
        contactList.put("Alice", "111-222-3333");
        System.out.println("HashMap after updating Alice: " + contactList);
        
        // Removing an entry
        contactList.remove("Charlie");
        System.out.println("HashMap after removing Charlie: " + contactList);
        
        // Iterating through the map
        System.out.println("\nIterating through HashMap using EntrySet:");
        for (Map.Entry<String, String> entry : contactList.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Phone: " + entry.getValue());
        }

        // --- LinkedHashMap: Maintains insertion order of key-value pairs ---
        System.out.println("\n--- LinkedHashMap Demonstration ---");
        Map<String, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put("Key1", "Value1");
        linkedMap.put("Key3", "Value3");
        linkedMap.put("Key2", "Value2");
        System.out.println("LinkedHashMap (insertion order): " + linkedMap);

        // --- TreeMap: Stores key-value pairs in sorted order by key ---
        System.out.println("\n--- TreeMap Demonstration ---");
        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("KeyC", "ValueC");
        treeMap.put("KeyA", "ValueA");
        treeMap.put("KeyB", "ValueB");
        System.out.println("TreeMap (sorted by key): " + treeMap);
    }
}
