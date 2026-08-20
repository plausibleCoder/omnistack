package com.learn.dsa.bedrock;
/**
 * Problem 1 — Add Digits

LeetCode #258 — Easy

Given an integer num, repeatedly add all its digits until only one digit remains.

Example 1

Input:

num = 38

Output:

2

Explanation:

3 + 8 = 11
1 + 1 = 2

Example 2

Input:

num = 12345

Output:

6

Because:

1 + 2 + 3 + 4 + 5 = 15
1 + 5 = 6

Your task: Write the Java solution.
 */
public class AddDigits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=3878;
		System.out.println(addDigitsIterative(num));
		System.out.println(addDigitsMathematical(num));
	}

	private static int addDigitsIterative(int num) {
		
		while(num > 10) {
			int digitSum=0;
			while(num >0) {
				digitSum = digitSum + (num%10); //Gets the last digit
				num = num/10; //remove the last digit;
			}
			num = digitSum;
		}
		return num;
	}
	
	private static int addDigitsMathematical(int num) {
		 return 1 + (num - 1) % 9;
	}
	
	

}
