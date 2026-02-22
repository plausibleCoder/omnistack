package com.learn.dsa.basic.slidingwindow;
import java.util.*;
/*
Longest Substring with K Distinct Characters
The Goal: Given a string, find the length of the longest substring that contains no more than K distinct characters.

Example:

String: "araaci"

K: 2

Let's analyze the substrings:

"araa": Has 2 distinct characters (a, r). Length is 4.

"aaci": Has 3 distinct characters (a, c, i). This is invalid.

"ci": Has 2 distinct characters (c, i). Length is 2.

The longest valid substring is "araa". So the answer is 4.

Another example:

String: "cbbebi"

K: 3

The longest substring with no more than 3 distinct characters is "cbbeb", which has (c,b,e). The answer is 5.
*/
public class LongestSubstringWithKDifferentCharacters {

    public static void main(String[] args){
        findLength("araaci",2);
    }

    public static int findLength(String str, int k){


        int maxLength=0;
        Map<Character, Integer> charFrequencyMap= new HashMap<>();;
        char arr[] = str.toCharArray();
        int iteration=1;
        int count=0;
        for(int i=0;i<str.length();i++){
            if(charFrequencyMap.containsKey(arr[i])){
            
           // charFrequencyMap.put(arr[i],Integer.parseInt(charFrequencyMap.get(arr[i]))++);
            }
        }
        System.out.println(charFrequencyMap);
        return maxLength == Integer.MAX_VALUE? 0 : maxLength;
    }

}