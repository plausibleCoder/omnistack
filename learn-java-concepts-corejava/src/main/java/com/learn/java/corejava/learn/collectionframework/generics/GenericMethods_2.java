package com.learn.java.corejava.learn.collectionframework.generics;

public class GenericMethods_2 {
	
	public static <T> void printArray(T[] val) {
		
		for(T entry: val) {
			System.out.println(entry);
		}
	}
	
	public static void main(String[] args) {
		
		 Integer[] integerArray = {1, 2, 3, 4, 5};
	        String[] stringArray = {"apple", "banana", "orange"};

	        System.out.println("Printing Integer Array:");
	        printArray(integerArray);

	        System.out.println("\nPrinting String Array:");
	        printArray(stringArray);
	}

}
