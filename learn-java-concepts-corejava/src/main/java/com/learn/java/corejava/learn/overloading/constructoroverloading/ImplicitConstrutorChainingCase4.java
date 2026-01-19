package com.learn.java.corejava.learn.overloading.constructoroverloading;

import java.io.IOException;

public class ImplicitConstrutorChainingCase4 {

}

class P3 {
	P3() throws IOException{
		
	}
}

//class C3 extends P3{ //Default constructor cannot handle exception type IOException thrown by implicit super constructor. Must define an explicit constructor
//	C(){
//		super();
//	}
//}