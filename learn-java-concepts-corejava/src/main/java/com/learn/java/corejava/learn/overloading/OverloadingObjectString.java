package com.learn.java.corejava.learn.overloading;

public class OverloadingObjectString {
	
	public void m1(String s) {

		System.out.println("String version");
	}
	
	public void m1(Object o) {
		System.out.println("Object version");
	}
	public static void main(String[] args) {
	
		
		OverloadingObjectString t = new OverloadingObjectString();
		t.m1(new Object()); //Object version
		t.m1("Karthik");//String version
		/*
		 Explanation: The null literal can be assigned to any reference type, including both String and Object.
		  Because String is a child class of Object, the m1(String s) method is considered more specific than m1(Object o).
		  When a null argument is passed, the compiler will always resolve to the most specific matching method to avoid ambiguity. 
		 */
		t.m1(null);// String version
		/*
		 What would cause an ambiguity error?
			An ambiguity error would occur if you had two overloaded methods for which neither was more specific than the other.
			 For example, if you had m1(String) and m1(Integer) and passed null to m1(),
			 the compiler would not know which one to pick, as there is no inheritance relationship between String and Integer.
		 */
	}
}
