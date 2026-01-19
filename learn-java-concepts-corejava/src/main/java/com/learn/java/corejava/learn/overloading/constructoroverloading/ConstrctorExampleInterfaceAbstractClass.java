package com.learn.java.corejava.learn.overloading.constructoroverloading;
/*
 Every class in java including the abstract class can contain constructor but interface cannot have a constructor
 */
public class ConstrctorExampleInterfaceAbstractClass {

}

class TestClass implements TestInterface{
	TestClass(){
		
	}

	@Override
	public int checkBalance(int i, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int SubtractBalance(int i, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int UpdatetBalance(int i, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}

abstract class TestAbstract{
	TestAbstract(){
		
	}
	
	 abstract int checkBalance(int i, int b);
	public abstract int SubtractBalance(int i, int b);
	public abstract int UpdatetBalance(int i, int b);
}

interface TestInterface{
	//TestInterface(){
		
	//}
	private int add(int i, int b) {
		return i+b;
	}
	
	public int checkBalance(int i, int b);
	public int SubtractBalance(int i, int b);
	public int UpdatetBalance(int i, int b);
	
	
}
