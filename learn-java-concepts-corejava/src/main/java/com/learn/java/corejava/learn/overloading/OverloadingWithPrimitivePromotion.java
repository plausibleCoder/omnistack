package com.learn.java.corejava.learn.overloading;

public class OverloadingWithPrimitivePromotion {

	public static void main(String[] args) {
		OverloadingWithPrimitivePromotion t = new OverloadingWithPrimitivePromotion();
		t.m1(10, 10f);//int -float version
		t.m1(10.5f, 10);//float-int version
		/*
		 When you make the call t.m1(10, 10), the compiler follows a strict set of rules for method overloading:
Look for an exact match: It first searches for a method with the signature m1(int, int). There is no such method, so it moves to the next step.
Look for a match with widening: It considers widening primitive conversions. An int can be implicitly widened (promoted) to a float.
Option 1: Call m1(int i, float f). This is a valid option because the second int argument can be widened to a float.
Option 2: Call m1(float f, int i). This is also a valid option because the first int argument can be widened to a float.
Resolve ambiguity: The compiler now has two equally valid options for the t.m1(10, 10) call, and neither is "more specific" than the other. 
Since it cannot make a definitive choice, it flags an ambiguous method call error at compile-time
		 */
		//t.m1(10, 10);
		
		/*
		 It cannot convert the first float argument to an int for m1(float, int) 
		 because that would be a narrowing conversion (potential loss of data).
It cannot find a method m1(float, float).
Since there is no widening path from float to int and no matching method signature, 
the compiler produces an error stating that the method is not applicable for the arguments provided. 
		 */
		//t.m1(10.5f, 10.5f);//The method m1(float, int) in the type OverloadingWithPrimitivePromotion 
		//is not applicable for the arguments (float, float)
		
	}
	
	public void m1(int i, float f) {
		System.out.println("int - float vesion");
	}
	
	public void m1(float f, int i){
		System.out.println("float - int version");
	}

}
