package com.learn.java.corejava.learn.hasarelationship.restrictinheritance;

public class RestrictChildClassByPrivateConstructor {

	//P() has private access in P
	public static void main(String[] args) {
		//P x = new C();
	}
	
	
//	It doesn't give a compile-time error because the code, as you have written it, is incomplete. 
//	The Java compiler will produce an error as soon as you actually try to create an instance of C
	class P{
		private P() {
			
		}
	}
	class C extends P{
		C(){
			super();
		}
	}

}
