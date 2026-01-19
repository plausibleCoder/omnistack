package com.learn.java.corejava.learn.overloading;
/*
 Variable args gets the least priority
 */
public class OverloadingVarargsPriority {

	public static void main(String[] args) {
		OverloadingVarargsPriority t = new OverloadingVarargsPriority();
		
		t.m1(); //var-args method
		t.m1(10,20);// var-args method
		/*
		 Here general method is old version so it gives priority to General method
		 */
		t.m1(10);//general method 
	}
	public void m1(int x) {
		System.out.println("General method");
	}
	
	public void m1(int... x) {
		System.out.println("Var-args method");
	}

}
