package com.learn.java.corejava.learn.declarationsandaccessmodifiers;

//for classes and methods but not for variables
public class AbstractModifier extends  Test2 {

	@Override
	void m1() {
		// TODO Auto-generated method stub
		
	}
	
	//abstract public void m1();
}


abstract class Test{
	
//cannot declare methods as below
//	abstract final void m1();
//	abstract native void m2();
//	abstract synchronized void m2();
//	abstract static void m2();
//	abstract private void m2();
//	abstract strictfp void m2();
	
}

abstract class Test2{
	abstract void m1();
	
	public void m2() {
		System.out.println("Hi there");
	}
	
}
abstract class Test3{
	public final void m1() {
		
	}
	
}
