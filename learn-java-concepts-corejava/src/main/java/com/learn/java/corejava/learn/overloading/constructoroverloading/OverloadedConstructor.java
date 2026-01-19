package com.learn.java.corejava.learn.overloading.constructoroverloading;

public class OverloadedConstructor {

	//OverloadedConstructor obj1 = new OverloadedConstructor(10);
	
	
	

	/*
	 this(): The keyword this() is used inside a constructor to explicitly call another overloaded constructor of the same class. 
	 This is called constructor chaining.
	 
	 Constructor Chaining: This technique helps reuse initialization code and ensures that all constructors follow a single, consistent setup process. 
	 A this() call must always be the very first statement in a constructor.
	 */
	OverloadedConstructor(){
		this(10);
		System.out.println("no args");
		//System.out.println("Grishma");
	}
	
	OverloadedConstructor(int i){
		this(10.5);
		System.out.println("int args");
	}
	
	OverloadedConstructor(double d){
		System.out.println("double args");
	}
	
	public static void main(String[] args) {
		/*
		 OverloadedConstructor t = new OverloadedConstructor();
This statement calls the no-argument constructor.
OverloadedConstructor() is called.
The first line of this constructor is this(10);, which immediately calls the int constructor.
OverloadedConstructor(int i) is called.
The first line of this constructor is this(10.5);, which immediately calls the double constructor.
OverloadedConstructor(double d) is called.
The body of this constructor is executed, printing "double args".
Control returns to the int constructor. Its body is executed, printing "int args".
Control returns to the no-argument constructor. Its body is executed, printing "no args"
		 */
		OverloadedConstructor t = new OverloadedConstructor();
		System.out.println();
		OverloadedConstructor t2 = new OverloadedConstructor(10);
		System.out.println();
		OverloadedConstructor t3 = new OverloadedConstructor(10.5);
		System.out.println();
		OverloadedConstructor t4 = new OverloadedConstructor(10l);
	}

}
