package com.learn.dsa.basic.strings;

import java.util.Set;

public class VowelCount {

	public static void main(String[] args) {
		// Test cases: "hello", "programming", "aeiou"

		System.out.println(countVowelsA1("hello"));
		System.out.println(countVowelsA1("programming"));
		System.out.println(countVowelsA1("aeiou"));
		
		
		System.out.println(countVowelsA2("hello"));
		System.out.println(countVowelsA2("programming"));
		System.out.println(countVowelsA2("aeiou"));
	}



	private static int countVowelsA1(String str) {
		if(str==null) return 0;
		
		int count = 0;
		Set <Character> vowels = Set.of('a','e','i','o','u','A','E','I','O','U'); 
		for(int j=0;j<str.length();j++) {
			if(vowels.contains(str.charAt(j))) {
				count++;
			}
		}
		
		return count;
	}
	private static int countVowelsA2(String str) {
		if(str==null) return 0;
		String vowels="aeiouAEIOU";
		int count=0;
		
		for(int i=0;i<str.length();i++) {
			if(vowels.indexOf(str.charAt(i)) != -1) {
				count++;
			}
		}
		
		
		return count;
	}

}
