package com.learn.java.corejava.learn.overloading;

class Animal{}
class Donkey extends Animal{}

public class OverloadingOverHierarchy {

	public void m1(Animal a) {
		System.out.println("Animal vesion");
	}
	public void m1(Donkey d) {
		System.out.println("Donkey vesion");
	}
	
	public static void main(String[] args) {
		OverloadingOverHierarchy t = new OverloadingOverHierarchy();
		Animal a = new Animal();
		t.m1(a);//Animal version
		Donkey d = new Donkey();
		t.m1(d);//donkey version
		Animal a1 = new Donkey();//In overloading runtime object will not not play any role. Here type is Animal
		
		/*
		 Explanation: This is the crucial line. The compiler only looks at the compile-time reference type, which is Animal. 
		 It sees a method call with an Animal reference and finds an exact match with m1(Animal a). 
		 The fact that the object at run-time is a more specific Donkey instance is ignored for overloading. The output is "Animal vesion".
		 */
		t.m1(a1);// Animal version
		
		/*
		 This example highlights a key difference between method overloading and overriding:
			Method Overloading (Compile-time polymorphism): The method to be called is determined by the compiler based on the reference type. 
			In the case of inheritance, the most specific method is chosen if the reference type matches a child class.
			
			Method Overriding (Runtime polymorphism): The method to be called is determined by the JVM at runtime, based on the actual object type. 
			If m1 were an overridden method, t.m1(a1) would have executed the Donkey version
					 */
		
	}
	

	

}
