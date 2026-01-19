package com.learn.java.corejava.learn.declarationsandaccessmodifiers;

import static java.lang.Math.*;
import static java.lang.Math.sqrt;

import static java.lang.System.out;

public class StaticImportsExample {

	public static void main(String[] args) {
		System.out.println(sqrt(4));
		System.out.println(max(10,20));
		System.out.println(random());
		
		out.println("Hi");
	}

}
