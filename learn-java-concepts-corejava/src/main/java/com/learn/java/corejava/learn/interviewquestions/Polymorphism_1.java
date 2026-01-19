package com.learn.java.corejava.learn.interviewquestions;

public class Polymorphism_1 {
	/*
	Static polymorphism (or)
	compile time polymorphism (or)
	early loading 
	# Overloading and method hiding are 2 types 
	*/
	
	public int add(int i, int j) {
		return i+j;
	}
	
	public double add(double i, double j) {
		return i+j;
	}
	
	public static int subtract(int i, int j) {
		return i-j;
	}
	public static double subtract(double i, double j) {
		return i-j;
	}
	public static void main(String[] args) {
		
	}
}

/*
Dynamic polymorphism (or)
Runtime Time (or)
Late binding
# Overriding is one type
*/
class OverrideSample extends Polymorphism_1{
	public static int subtract(int i, int j) {
		if(i>j) return i-j;
		else return j-i;
	}
}

