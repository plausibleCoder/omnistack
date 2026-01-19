package com.learn.java.corejava.learn.overloading.constructoroverloading;

import java.io.IOException;

public class ImplicitConstrutorChainingCase5 {

}

class P4{
	P4() throws IOException{
		
	}
}

class C4 extends P4{
	C4() throws IOException //or Exception or Throwable
	{
		super();
	}
}
/*
Child class C4:
The constructor C4() implicitly calls the parent's constructor using super() as its first statement.
Since the superclass constructor (P4()) is a checked exception, the child class constructor (C4()) must also handle this exception.
In a constructor, the super() call must be the very first statement, which means it cannot be wrapped in a try-catch block.
The only remaining option for the C4() constructor is to declare that it also throws IOException. This "propagates" the exception up the call stack, 
telling anyone who creates a C4 object that they will have to handle this potential exception
*/