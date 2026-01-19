package com.learn.java.corejava.learn.collectionframework.collection.list;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class CursorsDemo {

    public static void main(String[] args) {
        // --- Enumeration: Legacy, read-only, for Vector/Hashtable ---
        System.out.println("--- Enumeration Demo (Legacy) ---");
        Vector<String> vector = new Vector<>();
        vector.add("Element1");
        vector.add("Element2");
        vector.add("Element3");

        Enumeration<String> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println("Next element: " + enumeration.nextElement());
        }
        // Enumeration does not support remove() method.

        // --- Iterator: Universal, one-way traversal, supports remove() ---
        System.out.println("\n--- Iterator Demo (Universal) ---");
        List<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println("Next element: " + fruit);
            if ("Banana".equals(fruit)) {
                iterator.remove(); // Can remove elements
            }
        }
        System.out.println("List after Iterator removal: " + list);
        
        // --- ListIterator: Bidirectional, for List implementations only ---
        System.out.println("\n--- ListIterator Demo (List only) ---");
        List<String> list2 = new ArrayList<>();
        list2.add("Apple");
        list2.add("Banana");
        list2.add("Orange");

        ListIterator<String> listIterator = list2.listIterator();
        
        System.out.println("Forward traversal:");
        while (listIterator.hasNext()) {
            String fruit = listIterator.next();
            if ("Banana".equals(fruit)) {
                listIterator.set("Grapes"); // Can replace element
            }
        }
        System.out.println("List after forward traversal (replacement): " + list2);

        System.out.println("Backward traversal:");
        while (listIterator.hasPrevious()) {
            System.out.println("Previous element: " + listIterator.previous());
        }
        
        // Add new element at the current position
        listIterator.add("Cherry");
        System.out.println("List after ListIterator add: " + list2);
    }
}
