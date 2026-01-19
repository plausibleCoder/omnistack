package com.learn.java.corejava.learn.overloading.constructoroverloading;

public class ImplicitConstrutorChainingCase3 {

}

class P2{
	P2(int i){
		super();
	}
}

//class C2 extends P2{
//	C2(){
//		super();//The constructor P2() is undefined
//		////Implicit super constructor P2() is undefined. Must explicitly invoke another constructor
//	}
//}

/*
 * Whenever we are writing any argument constructor it is highly recommended to write no arg construtor also
 * If parent class contain any arguement constructor, then while writing the child classes. we have to take special care, wrt construtor
 */

