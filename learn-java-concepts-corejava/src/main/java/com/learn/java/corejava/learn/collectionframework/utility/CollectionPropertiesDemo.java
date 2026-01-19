package com.learn.java.corejava.learn.collectionframework.utility;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollectionPropertiesDemo {
    /*
     * This class categorizes various collection classes based on key properties.
     * We use a helper method to check for each property and print the results.
     *
     * - Serializable: Can an object be serialized (written to a file/stream)?
     * - Cloneable: Does the class support object cloning?
     * - RandomAccess: Does the list support fast (constant time) random access?
     * - Synchronized: Is the collection thread-safe by default?
     */
    public static void main(String[] args) {
        System.out.println("--- Categorizing Collection Classes by Properties ---");
        System.out.println(String.format("%-25s | %-12s | %-12s | %-15s | %s",
                "Class", "Serializable", "Cloneable", "RandomAccess", "Synchronized"));
        System.out.println("----------------------------------------------------------------------------------");

        // List implementations
        printProperties(new ArrayList<>(), "ArrayList");
        printProperties(new LinkedList<>(), "LinkedList");
        printProperties(new Vector<>(), "Vector");

        // Set implementations
        printProperties(new HashSet<>(), "HashSet");

        // Queue/Deque implementations
        printProperties(new java.util.PriorityQueue<>(), "PriorityQueue");
        printProperties(new java.util.ArrayDeque<>(), "ArrayDeque");
        
        // Map implementations (Note: Map does not implement Collection, so we check it separately)
        printMapProperties(new HashMap<>(), "HashMap");
        printMapProperties(new java.util.Hashtable<>(), "Hashtable");
        
        // Utility classes and concurrent collections
        printProperties(Collections.synchronizedList(new ArrayList<>()), "SynchronizedList");
        printProperties(new CopyOnWriteArrayList<>(), "CopyOnWriteArrayList");
    }

    /**
     * Prints the properties for a given object that implements the Collection interface.
     */
    private static void printProperties(Object obj, String className) {
        System.out.println(String.format("%-25s | %-12s | %-12s | %-15s | %s",
                className,
                obj instanceof Serializable ? "Yes" : "No",
                obj instanceof Cloneable ? "Yes" : "No",
                obj instanceof RandomAccess ? "Yes" : "No",
                isSynchronized(obj.getClass()) ? "Yes" : "No"));
    }
    
    /**
     * Prints the properties for a given object that implements the Map interface.
     */
    private static void printMapProperties(Map<?, ?> map, String className) {
        System.out.println(String.format("%-25s | %-12s | %-12s | %-15s | %s",
                className,
                map instanceof Serializable ? "Yes" : "No",
                map instanceof Cloneable ? "Yes" : "No",
                "N/A", // Maps don't have the RandomAccess property
                isSynchronized(map.getClass()) ? "Yes" : "No"));
    }

    /**
     * A helper method to check for synchronization by inspecting the class name.
     * This is a simple, but effective, approach for this demo.
     */
    private static boolean isSynchronized(Class<?> clazz) {
        String className = clazz.getName();
        return className.contains("Vector") || className.contains("Hashtable") || className.contains("Synchronized");
    }
}
