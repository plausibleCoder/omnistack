package com.learn.java.corejava.learn.collectionframework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionDemo {
    /*
    The Collection interface extends Iterable. It represents a group of objects.
    It defines fundamental methods for a collection, such as add, remove, contains, size, etc.
    List, Set, and Queue are sub-interfaces of Collection.
    */
    public static void main(String[] args) {
        System.out.println("--- Demonstrating the Collection interface ---");

        // We use an ArrayList as a concrete implementation of Collection
        Collection<String> collection = new ArrayList<>();

        // 1. Adding elements
        collection.add("Data A");
        collection.add("Data B");
        collection.add("Data C");
        System.out.println("Initial collection: " + collection);

        // 2. Getting size
        System.out.println("Size of collection: " + collection.size());

        // 3. Checking for an element
        System.out.println("Does collection contain 'Data B'? " + collection.contains("Data B"));

        // 4. Removing an element
        collection.remove("Data B");
        System.out.println("Collection after removing 'Data B': " + collection);
        System.out.println("Does collection contain 'Data B' now? " + collection.contains("Data B"));

        // 5. Adding another collection
        Collection<String> anotherCollection = new ArrayList<>();
        anotherCollection.add("Data D");
        anotherCollection.add("Data E");
        collection.addAll(anotherCollection);
        System.out.println("Collection after adding another collection: " + collection);
        
        // 6. Clearing the collection
        collection.clear();
        System.out.println("Collection after clearing: " + collection);
        System.out.println("Is collection empty? " + collection.isEmpty());
    }
}
