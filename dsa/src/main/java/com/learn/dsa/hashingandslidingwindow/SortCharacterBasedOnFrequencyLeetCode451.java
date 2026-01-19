package com.learn.dsa.hashingandslidingwindow;
import java.util.*;
/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters. 
 * The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

problem links: leetcode, geekforgeeks.

Example 1:


Copy

Copy
Input: s = "tree" 
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once. 
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

Example 2:


Copy

Copy
Input: s = "cccaaa" 
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers. Note that "cacaca" is incorrect, as the same characters must be together.

Example 3:


Copy

Copy
Input: s = "Aabb" 
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note that 'A' and 'a' are treated as two different characters.

Constraints:

1 <= s.length <= 5 * 10<sup>5</sup>

s consists of uppercase and lowercase English letters and digits.
 */
public class SortCharacterBasedOnFrequencyLeetCode451 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(frequencySort("cccaaa"));
		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("Aabb"));
		
		System.out.println(frequencySortApproachAbhishek("cccaaa"));
		System.out.println(frequencySortApproachAbhishek("tree"));
		System.out.println(frequencySortApproachAbhishek("Aabb"));

	}
	
	//From internet
	 public static String frequencySort(String s) {
	        Map<Character, Integer> frequencyMap = new HashMap<>();
	        for(char ch : s.toCharArray()) {
	            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
	        }

	        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
	        for(Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
	            maxHeap.add(entry);
	        }

	        StringBuilder sortedString = new StringBuilder("");
	        while(!maxHeap.isEmpty()) {
	            Map.Entry<Character, Integer> entry = maxHeap.poll();
	            for(int i = 0; i < entry.getValue(); i++) {
	                sortedString.append(entry.getKey());
	            }
	        }

	        return sortedString.toString();
	    }
	 
	 public static String frequencySortApproachAbhishek(String s) {
		 
		 //create custom comparator
		 
		 return "";
	 }

}
