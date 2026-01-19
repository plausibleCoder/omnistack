package com.learn.dsa.basic.strings;

public class PalindromeCheck {

	public static void main(String[] args) {
		// Test cases: "radar", "hello"
		System.out.println(isPalindrome("radar"));
		System.out.println(isPalindrome("hello"));
		System.out.println(isPalindrome("reer"));

	}

	private static boolean isPalindrome(String str) {
		if (str != null) {
			int lastIndex = str.length();
			int firstIndex = 0;
			while (firstIndex != str.length() / 2) {
				if ((str.charAt(firstIndex) != str.charAt(lastIndex-1))) {
					return false;
				}
				firstIndex++;
				lastIndex--;
			}
		} else {

			return false;
		}
		return true;
	}
}