package com.learn.java.corejava.learn;

import com.learn.java.corejava.learn.declarationsandaccessmodifiers.ProtectedAccessModifier;

public class TestProtectedAccessModifier extends ProtectedAccessModifier {

	public static void main(String[] args) {
		
		TestProtectedAccessModifier obj= new TestProtectedAccessModifier();
		obj.m1();
		
		ProtectedAccessModifier obj2 = new ProtectedAccessModifier();
		//obj2.m1();

	}

}
