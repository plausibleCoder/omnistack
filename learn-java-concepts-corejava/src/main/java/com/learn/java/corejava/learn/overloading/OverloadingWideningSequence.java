package com.learn.java.corejava.learn.overloading;
/*
 Integral Widening: The sequence for integers is based on size, as a larger container can always hold a smaller value.
byte → short → int → long
Character Widening: The char type can be widened into an int, long, float, or double.
char → int → long → float → double
Floating-Point Widening:
float → double
 */
public class OverloadingWideningSequence  {

	public static void main(String[] args) {
		Test t = new Test();
		/*
		 Widening sequence 
		 byte -> short ->
		      -> char -> int -> long ->float->double
		 */
		t.m1(10);
		t.m1(10.5f);
		t.m1('A');
		/*
		 Explanation: The Test class has no m1(char) method. However,
		  char can be automatically promoted (widened) to int because it is a smaller data type.
		  The compiler promotes 'a' to its ASCII integer value and calls the m1(int i) method.
		 */
		t.m1(10l);
		/*
		 In Java, floating-point literals with a decimal point (like 10.5) are treated as a double by default. 
		 While the compiler can automatically convert a smaller data type to a larger one (a process called widening),
		 it will not convert a larger data type to a smaller one (narrowing) implicitly.
		  In this case, double is a larger data type than float, so the compiler cannot implicitly convert 10.5 (a double) to a float.
		  
		 */
		
		//t.m1(10.5);
		int j = 100/5;
	}

}

class Test {

	public void m1(int i) {

		System.out.println("int -args : " + i);
	}

	public void m1(float f) {
		System.out.println("float-args : " + f);

	}
}
