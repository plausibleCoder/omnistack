package com.learn.dsa.basic.general;

import java.util.stream.IntStream;


public class PrintEvenNumbers {

	public static void main(String[] args) {
		
		printEvenNumbers(2, 20);
		printEvenNumbersInStreams(2, 20);

	}

	private static void printEvenNumbersInStreams(int start, int end) {
		IntStream.rangeClosed(start, end).filter(i-> i%2==0).forEach(System.out::println);
		
	}

	private static void printEvenNumbers(int start, int end) {
		
		for(int i=start;i<=end;i++) {
			if(i%2==0) {
			System.out.println(i);
			}
			
		}
		
	}

}
