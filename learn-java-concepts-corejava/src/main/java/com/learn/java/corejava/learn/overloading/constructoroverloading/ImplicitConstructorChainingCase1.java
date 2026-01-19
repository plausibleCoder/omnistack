package com.learn.java.corejava.learn.overloading.constructoroverloading;

public class ImplicitConstructorChainingCase1 {
	
}
class P {
	/*
	 Class ImplicitConstructorChainingCase1: This class is a child of Object 
	 (all classes that do not explicitly extend another class implicitly extend java.lang.Object).
	  Its constructor, ImplicitConstructorChainingCase1(), contains an explicit call to super(). 
	  Since super() refers to the constructor of the immediate parent class, 
	  this is a call to Object's default constructor. 
	 Even if you removed this line, the compiler would insert it automatically, making the explicit call redundant.
	 */
	P(){
		super();
	}

	
}
/*
 Class C: This class extends ImplicitConstructorChainingCase1. Its constructor, C(), also explicitly calls super(). 
 This super() call invokes the no-argument constructor of its immediate parent, ImplicitConstructorChainingCase1(). 
 Again, because the C() constructor performs no other constructor call, 
 the compiler would have inserted this super() call implicitly, so the explicit line is not strictly necessary
 */
class C extends P{
	
	C(){
		super();
	}
	
}


//In essence, your code is functionally identical to this version, which relies on implicit calls:

//public class P {
//    // A default constructor will be implicitly created by the compiler.
//    // That constructor will implicitly call super().
//}
//
//class C extends P {
//    // A default constructor will be implicitly created by the compiler.
//    // That constructor will implicitly call super().
//}
