package com.learn.java.corejava.learn.collectionframework;

import com.learn.java.corejava.learn.collectionframework.collection.CollectionVsCollections;
import com.learn.java.corejava.learn.collectionframework.collection.list.CursorsDemo;
import com.learn.java.corejava.learn.collectionframework.collection.list.ListDemo;
import com.learn.java.corejava.learn.collectionframework.collection.queue.QueueDemo;
import com.learn.java.corejava.learn.collectionframework.collection.set.SetDemo;
import com.learn.java.corejava.learn.collectionframework.map.MapDemo;

public class CollectionFrameworkDemo {
    public static void main(String[] args) {
        System.out.println("--- Collection vs Collections Demo ---");
        CollectionVsCollections.main(null);
        System.out.println("\n--- List Interface Demo ---");
        ListDemo.main(null);
        System.out.println("\n--- Set Interface Demo ---");
        SetDemo.main(null);
        System.out.println("\n--- Queue Interface Demo ---");
        QueueDemo.main(null);
        System.out.println("\n--- Map Interface Demo ---");
        MapDemo.main(null);
        System.out.println("\n--- Sorting with Comparable and Comparator Demo ---");
        SortingDemo.main(null);
        System.out.println("\n--- Cursors: Enumeration, Iterator, ListIterator Demo ---");
        CursorsDemo.main(null);
    }
}
