package com.learn.java.corejava.learn.overloading.constructoroverloading;

public class RecursviveConstrutorInvocation {
	public static void main(String[] args) {
		System.out.println("Hello");
	}
	/*
	 When an object is created, the constructor call will enter a continuous loop:
new RecursviveConstrutorInvocation() is called.
The no-argument constructor this(10); is invoked.
The int-argument constructor this(); is invoked.
The call returns to the no-argument constructor, repeating the cycle. 
This loop would continue forever, or until the program runs out of memory and produces a StackOverflowError at runtime.
	 */
	
	RecursviveConstrutorInvocation(){
		//this(10);
	}
	RecursviveConstrutorInvocation(int i){
		//this();
	}
	
	
	
}
