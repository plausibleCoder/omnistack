package com.learn.java.corejava.learn.collectionframework.utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizationDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("--- Demonstrating Synchronization in Collections ---");

        // 1. Demonstrate thread-safety with Vector
        System.out.println("\n--- Using a Synchronized Vector (Thread-Safe) ---");
        Vector<Integer> vector = new Vector<>();
        runConcurrentThreads(vector, "Vector");
        System.out.println("Final size of Vector: " + vector.size());

        // 2. Demonstrate lack of thread-safety with ArrayList
        System.out.println("\n--- Using a Non-Synchronized ArrayList (Not Thread-Safe) ---");
        List<Integer> nonSyncList = new ArrayList<>();
        runConcurrentThreads(nonSyncList, "ArrayList");
        System.out.println("Final size of ArrayList: " + nonSyncList.size());
        System.out.println("Note: The size is likely not " + 10000 + " due to race conditions.");

        // 3. Demonstrate manually creating a synchronized list
        System.out.println("\n--- Manually Synchronizing an ArrayList ---");
        List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
        runConcurrentThreads(syncList, "SynchronizedList");
        System.out.println("Final size of Synchronized List: " + syncList.size());
    }

    private static void runConcurrentThreads(List<Integer> list, String name) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        int numberOfTasks = 10;
        int itemsPerTask = 1000;

        for (int i = 0; i < numberOfTasks; i++) {
            executor.submit(() -> {
                for (int j = 0; j < itemsPerTask; j++) {
                    list.add(j);
                }
            });
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println("Tasks finished for " + name);
    }
}
