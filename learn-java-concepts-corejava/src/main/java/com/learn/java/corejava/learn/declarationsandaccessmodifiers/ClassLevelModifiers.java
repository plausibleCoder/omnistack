package com.learn.java.corejava.learn.declarationsandaccessmodifiers;

public class ClassLevelModifiers {

	 static void main(String[] args) {

		//public private protected final
		 
		//default access within package
		
	}

}

//default class DefaultClass{
//	
//}

/**
 Note: Every Method present inside the final class is always final by default, 
 But every variable present inside the final class need not be final
 */
final class FinalClass{
	
	final public void m1() {
		final int i=0;
		//i =20;
	}
	public void m2() {
		int r=3;
	}
}






