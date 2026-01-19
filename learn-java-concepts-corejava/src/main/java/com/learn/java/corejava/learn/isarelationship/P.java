package com.learn.java.corejava.learn.isarelationship;

public class P{
	public void m1 () {
		System.out.println("parent");
	}
}

class C extends P {

	public void m2 () {
		System.out.println("child");
		
	}

	
}

class Test{
	
	public static void main (String[] args) {
		P p1= new C();
		p1.m1();
		//p1.m2();
		C c1= new C();
		c1.m1();
		c1.m2();
	}
}

