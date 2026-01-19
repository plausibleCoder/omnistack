package com.learn.java.corejava.learn.overloading.constructoroverloading;

public class StackOverflowErrorSample {
	/*
	 Exception in thread "main" java.lang.StackOverflowError
	at com.learn.java.corejava.learn.overloading.constructoroverloading.StackOverflowErrorSample.m2(StackOverflowErrorSample.java:10)
	at com.learn.java.corejava.learn.overloading.constructoroverloading.StackOverflowErrorSample.m1(StackOverflowErrorSample.java:7)
	at com.learn.java.corejava.learn.overloading.constructoroverloading.StackOverflowErrorSample.m2(StackOverflowErrorSample.java:10)
	at com.learn.java.corejava.learn.overloading.constructoroverloading.StackOverflowErrorSample.m1(StackOverflowErrorSample.java:7)
	at com.learn.java.corejava.learn.overloading.constructoroverloading.StackOverflowErrorSample.m2(StackOverflowErrorSample.java:10)
	at com.learn.java.corejava.learn.overloading.constructoroverloading.StackOverflowErrorSample.m1(StackOverflowErrorSample.java:7)
	 */
	
	public static void m1() {
		m2();
	}
	public static void m2() {
		m1();
	}

	public static void main(String[] args) {
		m1();
		System.out.println("Hello ");
	}
	
	

}
