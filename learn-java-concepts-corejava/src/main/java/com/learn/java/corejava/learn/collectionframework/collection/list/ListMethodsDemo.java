package com.learn.java.corejava.learn.collectionframework.collection.list;

import java.util.ArrayList;
import java.util.List;

public class ListMethodsDemo {

    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("Original list: " + fruits);

        // add(int index, E element): Inserts an element at a specific index
        fruits.add(1, "Grape");
        System.out.println("After add(1, \"Grape\"): " + fruits);

        // get(int index): Retrieves an element at a specific index
        System.out.println("Element at index 2: " + fruits.get(2));

        // set(int index, E element): Replaces an element at a specific index
        fruits.set(2, "Kiwi");
        System.out.println("After set(2, \"Kiwi\"): " + fruits);

        // remove(int index): Removes an element at a specific index
        fruits.remove(0);
        System.out.println("After remove(0): " + fruits);

        // indexOf(Object o): Returns the index of the first occurrence
        System.out.println("Index of 'Kiwi': " + fruits.indexOf("Kiwi"));

        // lastIndexOf(Object o): Returns the index of the last occurrence
        fruits.add("Kiwi");
        System.out.println("List with duplicate: " + fruits);
        System.out.println("Last index of 'Kiwi': " + fruits.lastIndexOf("Kiwi"));

        // subList(int fromIndex, int toIndex): Returns a view of a portion of the list
        List<String> subList = fruits.subList(1, 3);
        System.out.println("Sublist from index 1 to 3: " + subList);
    }
}
