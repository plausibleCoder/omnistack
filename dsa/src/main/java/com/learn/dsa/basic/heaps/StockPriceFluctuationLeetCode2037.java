package com.learn.dsa.basic.heaps;
import java.util.*;

/*
 * 17th July 2025
 */

class StockPriceFluctuationLeetCode2037 {
    private Map<Integer, Integer> prices;
    private PriorityQueue<int[]> maxHeap;
    private PriorityQueue<int[]> minHeap;
    private int latestTimestamp;

    public StockPriceFluctuationLeetCode2037() {
        prices = new HashMap<>();
        maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]); // max-heap
        minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]); // min-heap
        latestTimestamp = 0;
    }

    public void update(int timestamp, int price) {
        prices.put(timestamp, price);
        maxHeap.offer(new int[]{price, timestamp});
        minHeap.offer(new int[]{price, timestamp});
        latestTimestamp = Math.max(latestTimestamp, timestamp);
    }

    public int current() {
        return prices.get(latestTimestamp);
    }

    public int maximum() {
        while (true) {
            int[] top = maxHeap.peek();
            if (!prices.containsKey(top[1]) || prices.get(top[1]) != top[0]) {
                maxHeap.poll();
            } else {
                return top[0];
            }
        }
    }

    public int minimum() {
        while (true) {
            int[] top = minHeap.peek();
              if (!prices.containsKey(top[1]) || prices.get(top[1]) != top[0]) {
                minHeap.poll();
            } else {
                return top[0];
            }
        }
    }
    
    public static void main(String[] args) {
    	StockPriceFluctuationLeetCode2037 stockPrice = new StockPriceFluctuationLeetCode2037();

        // Test Case 1: Basic Operations
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        System.out.println("Current Price: " + stockPrice.current()); // Expected: 5
        System.out.println("Maximum Price: " + stockPrice.maximum()); // Expected: 10
        System.out.println("Minimum Price: " + stockPrice.minimum()); // Expected: 5
        System.out.println("---");

        // Test Case 2: Update Existing Timestamp
        stockPrice.update(1, 12);
        System.out.println("Current Price: " + stockPrice.current()); // Expected: 5
        System.out.println("Maximum Price: " + stockPrice.maximum()); // Expected: 12
        System.out.println("Minimum Price: " + stockPrice.minimum()); // Expected: 5
        System.out.println("---");

        // Test Case 3: More updates, including out-of-order
        stockPrice.update(4, 20);
        stockPrice.update(3, 8);
         System.out.println("Current Price: " + stockPrice.current());  // Expected: 20
        System.out.println("Maximum Price: " + stockPrice.maximum());  // Expected: 20
        System.out.println("Minimum Price: " + stockPrice.minimum()); // Expected: 5
        System.out.println("---");


          // Test Case 4: Updates that change the min and max
        stockPrice.update(5, 1);
          System.out.println("Current Price: " + stockPrice.current());  // Expected: 1
        System.out.println("Maximum Price: " + stockPrice.maximum());   // Expected: 20
        System.out.println("Minimum Price: " + stockPrice.minimum());   // Expected: 1
        System.out.println("---");

        // Test Case 5: Latest timestamp update
        stockPrice.update(6,25);
        System.out.println("Current Price: " + stockPrice.current()); // Expected: 25
         System.out.println("Maximum Price: " + stockPrice.maximum());  // Expected: 25
        System.out.println("Minimum Price: " + stockPrice.minimum());   // Expected: 1
        System.out.println("---");

          // Test Case 6: Updates with same timestamp
        stockPrice.update(6,30);
         System.out.println("Current Price: " + stockPrice.current()); // Expected: 30
         System.out.println("Maximum Price: " + stockPrice.maximum()); // Expected: 30
        System.out.println("Minimum Price: " + stockPrice.minimum());  // Expected: 1
         System.out.println("---");

         // Test Case 7: Single price
         StockPriceFluctuationLeetCode2037 singlePrice = new StockPriceFluctuationLeetCode2037();
        singlePrice.update(10, 100);
        System.out.println("Single Price: Current " + singlePrice.current()); // Expected 100
        System.out.println("Single Price: Max " + singlePrice.maximum()); // Expected 100
        System.out.println("Single Price: Min " + singlePrice.minimum()); // Expected 100
        System.out.println("---");
    }
}
