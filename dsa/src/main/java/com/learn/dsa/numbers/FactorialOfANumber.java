package com.learn.dsa.numbers;

public class FactorialOfANumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fact(5));

	}
	
	static int fact(int n) {
		if(n<1) {
			return 1;
		}
		return n * fact(n-1);
	}

}
