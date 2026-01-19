package com.learn.dsa.basic.heaps;

import java.util.*;

/*
 * 17th July 2025
 */
public class MergeKSortedArrayLists {

    public static List<Integer> mergeKSorted(List<List<Integer>> lists) {
        if (lists == null || lists.isEmpty()) {
            return new ArrayList<>();
        }

        // Create a min-priority queue to store elements along with their indices
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [value, listIndex, elementIndex]

        // Add the first element of each non-empty list to the priority queue
        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                pq.add(new int[]{lists.get(i).get(0), i, 0});
            }
        }

        List<Integer> result = new ArrayList<>();

        // Build the merged list
        while (!pq.isEmpty()) {
            int[] smallest = pq.poll();
            int val = smallest[0];
            int listIndex = smallest[1];
            int elementIndex = smallest[2];

            result.add(val);

            // Add the next element from the same list if it exists
            if (elementIndex + 1 < lists.get(listIndex).size()) {
                pq.add(new int[]{lists.get(listIndex).get(elementIndex + 1), listIndex, elementIndex + 1});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case 1
        List<List<Integer>> lists1 = new ArrayList<>();
        lists1.add(Arrays.asList(1, 4, 5));
        lists1.add(Arrays.asList(1, 3, 4));
        lists1.add(Arrays.asList(2, 6));
        List<Integer> mergedList1 = mergeKSorted(lists1);
        System.out.println("Merged List 1: " + mergedList1); // Output: [1, 1, 2, 3, 4, 4, 5, 6]

        // Test Case 2: Empty lists
        List<List<Integer>> lists2 = new ArrayList<>();
        lists2.add(Arrays.asList(10, 20));
        lists2.add(new ArrayList<>()); // Empty list
        lists2.add(Arrays.asList(5, 15));
        List<Integer> mergedList2 = mergeKSorted(lists2);
        System.out.println("Merged List 2: " + mergedList2); // Output: [5, 10, 15, 20]

        // Test Case 3: All empty lists
        List<List<Integer>> lists3 = new ArrayList<>();
        lists3.add(new ArrayList<>());
        lists3.add(new ArrayList<>());
        List<Integer> mergedList3 = mergeKSorted(lists3);
        System.out.println("Merged List 3: " + mergedList3); // Output: []
    }
}

