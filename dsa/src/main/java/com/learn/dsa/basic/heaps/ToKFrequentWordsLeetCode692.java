package com.learn.dsa.basic.heaps;
/**
 * Given an array of strings words and an integer k, return the k most frequent strings.

Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.

 

Example 1:

Input: words = ["i","love","leetcode","i","love","coding"], k = 2
Output: ["i","love"]
Explanation: "i" and "love" are the two most frequent words.
Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:

Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
Output: ["the","is","sunny","day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.
 

Constraints:

1 <= words.length <= 500
1 <= words[i].length <= 10
words[i] consists of lowercase English letters.
k is in the range [1, The number of unique words[i]]
 

Follow-up: Could you solve it in O(n log(k)) time and O(n) extra space?
 */

import java.util.*;
/*
 * 17th July 2025
 */

class ToKFrequentWordsLeetCode692 {

    public static void main(String[] args) {
        ToKFrequentWordsLeetCode692 solver = new ToKFrequentWordsLeetCode692(); // Create an instance of the class

        // Test Case 1: Basic example from LeetCode
        String[] words1 = {"i", "love", "leetcode", "i", "love", "coding"};
        int k1 = 2;
        List<String> result1 = solver.topKFrequent(words1, k1);
        System.out.println("Input: " + Arrays.toString(words1) + ", k = " + k1);
        System.out.println("Output: " + result1); // Expected: ["i", "love"]
        System.out.println("---");

        // Test Case 2: Different frequencies and lexicographical order
        String[] words2 = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k2 = 4;
        List<String> result2 = solver.topKFrequent(words2, k2);
        System.out.println("Input: " + Arrays.toString(words2) + ", k = " + k2);
        System.out.println("Output: " + result2); // Expected: ["the", "is", "sunny", "day"]
        System.out.println("---");

        // Test Case 3: All words have the same frequency, check lexicographical sorting
        String[] words3 = {"apple", "banana", "cat", "dog", "elephant"};
        int k3 = 3;
        List<String> result3 = solver.topKFrequent(words3, k3);
        System.out.println("Input: " + Arrays.toString(words3) + ", k = " + k3);
        System.out.println("Output: " + result3); // Expected: ["apple", "banana", "cat"]
        System.out.println("---");

        // Test Case 4: Words with varying frequencies and tie-breakers
        String[] words4 = {"a", "a", "b", "b", "b", "c", "c", "d"};
        int k4 = 2;
        List<String> result4 = solver.topKFrequent(words4, k4);
        System.out.println("Input: " + Arrays.toString(words4) + ", k = " + k4);
        System.out.println("Output: " + result4); // Expected: ["b", "a"]
        System.out.println("---");

        // Test Case 5: K is equal to the number of unique words
        String[] words5 = {"hello", "world", "hello"};
        int k5 = 2;
        List<String> result5 = solver.topKFrequent(words5, k5);
        System.out.println("Input: " + Arrays.toString(words5) + ", k = " + k5);
        System.out.println("Output: " + result5); // Expected: ["hello", "world"]
        System.out.println("---");

        // Test Case 6: Empty word array
        String[] words6 = {};
        int k6 = 1;
        List<String> result6 = solver.topKFrequent(words6, k6);
        System.out.println("Input: " + Arrays.toString(words6) + ", k = " + k6);
        System.out.println("Output: " + result6); // Expected: []
        System.out.println("---");

        // Test Case 7: K is 1
        String[] words7 = {"test", "test", "test", "apple", "apple"};
        int k7 = 1;
        List<String> result7 = solver.topKFrequent(words7, k7);
        System.out.println("Input: " + Arrays.toString(words7) + ", k = " + k7);
        System.out.println("Output: " + result7); // Expected: ["test"]
        System.out.println("---");
    }

    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count Frequencies
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Populate Min-Heap
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int freqA = freqMap.get(a);
            int freqB = freqMap.get(b);
            if (freqA != freqB) {
                return freqA - freqB; // Sort by frequency ascending
            } else {
                return b.compareTo(a); // If frequencies are equal, sort by word descending (lexicographical)
            }
        });

        for (String word : freqMap.keySet()) {
            pq.offer(word); // Add word to heap
            if (pq.size() > k) {
                pq.poll(); // Remove the element with the lowest frequency (or largest alphabetical if tied)
            }
        }

        // Step 3: Extract Results
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll());
        }

        // Step 4: Reverse the list as required
        Collections.reverse(result);

        return result;
    }
}
