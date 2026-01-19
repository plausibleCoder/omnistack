package com.learn.java.corejava.learn.encapsulation;

public class Test2 {

}
//not Tightly encapsulated
class A1
{
	int x=10;
}

//not Tightly encapsulated
class B1 extends A1{
	private int y=20;
}
//Not Tightly encapsulated
class C1 extends B1{
	private int z = 10;
	
}