package com.learn.java.corejava.learn.encapsulation;

public class Test1 {
}
//Tightly encapsulated
class A
{
	private int x=10;
	public void add() {
		int z = x+20;
	}
	
}
//Not Tightly encapsulated
class B extends A{
	
	int y=10;
}

//Tightly encapsulated
class C extends A{
	private int z=13;
}