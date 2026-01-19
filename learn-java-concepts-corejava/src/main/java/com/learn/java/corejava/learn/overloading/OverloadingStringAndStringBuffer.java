package com.learn.java.corejava.learn.overloading;

public class OverloadingStringAndStringBuffer {

	/*
	 Super class - Object
	 Child cLASS - String & StringBuffer
	 */
	public static void main(String[] args) {
		
		OverloadingStringAndStringBuffer t = new OverloadingStringAndStringBuffer();
		t.m1("Karthik");//String version
		t.m1(new StringBuffer("Karthik"));//String Buffer version 
		//t.m1(null);//The method m1(String) is ambiguous for the type OverloadingStringAndStringBuffer
		/*
		 Explanation: The null literal can be assigned to any reference type. 
		 In this case, null could be a valid argument for either m1(String s) or m1(StringBuffer sb).
		  Since String and StringBuffer are siblings in the class hierarchy and neither is more specific than the other,
		   the compiler cannot decide which method to call. 
		 This leads to a compilation error, specifically: The method m1(String) is ambiguous for the type OverloadingStringAndStringBuffer
		 */
		// Fixes the ambiguity by casting null to String
		//t.m1(null); // Will call "String version"

		// Fixes the ambiguity by casting null to StringBuffer
		t.m1((StringBuffer) null); // Will call "String Buffer Version"
	}
	
	public void m1(String s) {
		System.out.println("String version");
	}
	
	public void m1(StringBuffer sb) {
		System.out.println("String Buffer Version");
		
	}
	

}


