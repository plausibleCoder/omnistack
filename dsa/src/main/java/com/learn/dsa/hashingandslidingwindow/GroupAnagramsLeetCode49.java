package com.learn.dsa.hashingandslidingwindow;
import java.util.*;
/**
 * 
 * July 13th 2025
 * LeetCode 49
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.

 

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]

 

Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
public class GroupAnagramsLeetCode49 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs= {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagramsCategorizeBySorting(strs));

	}
	
	public static List<List<String>> groupAnagramsCategorizeBySorting(String[] strs) {

	    if (strs == null || strs.length == 0)
	      return new ArrayList<>();

	    Map<String, List<String>> stringAnagramsMap = new HashMap<>();
	    for (String s : strs) {
	      char[] arr = s.toCharArray();
	      Arrays.sort(arr);
	      String key = String.valueOf(arr);

	      if (!stringAnagramsMap.containsKey(key))
	        stringAnagramsMap.put(key, new ArrayList<>());

	      stringAnagramsMap.get(key).add(s);
	    }

	    List<List<String>> resultList = new ArrayList<>();
	    for (Map.Entry<String, List<String>> stringAnagrams : stringAnagramsMap.entrySet()) {
	      resultList.add(stringAnagrams.getValue());
	    }
	    return resultList;
	  }

}
