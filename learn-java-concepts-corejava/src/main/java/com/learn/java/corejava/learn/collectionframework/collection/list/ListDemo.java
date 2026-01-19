package com.learn.java.corejava.learn.collectionframework.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        // Creating a List using ArrayList
    	
        List<String> names = new ArrayList<>();
        
        // add(E e): Adds an element to the end of the list
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Alice"); // Lists allow duplicates
        System.out.println("Initial List: " + names);
        
        // add(int index, E element): Inserts an element at a specific index
        names.add(1, "Daniel");
        System.out.println("List after adding Daniel at index 1: " + names);
        
        // get(int index): Returns the element at the specified position
        String firstElement = names.get(0);
        System.out.println("First element: " + firstElement);
        
        // set(int index, E element): Replaces the element at the specified position
        names.set(2, "Carol");
        System.out.println("List after replacing Bob with Carol: " + names);
        
        // remove(Object o): Removes the first occurrence of the specified element
        names.remove("Alice");
        System.out.println("List after removing the first Alice: " + names);
        
        // indexOf(Object o): Returns the index of the first occurrence of an element
        int index = names.indexOf("Carol");
        System.out.println("Index of Carol: " + index);
        
        // lastIndexOf(Object o): Returns the index of the last occurrence
        int lastIndex = names.lastIndexOf("Alice"); // will be -1 as the first one was removed
        System.out.println("Last index of Alice: " + lastIndex);
        
        // size(): Returns the number of elements
        System.out.println("Current list size: " + names.size());
        
        // contains(Object o): Checks if the list contains the element
        System.out.println("Does the list contain Bob? " + names.contains("Bob"));
        
        // clear(): Removes all elements from the list
        names.clear();
        System.out.println("List after clearing: " + names);
        System.out.println("Is the list empty? " + names.isEmpty());
    }
}
