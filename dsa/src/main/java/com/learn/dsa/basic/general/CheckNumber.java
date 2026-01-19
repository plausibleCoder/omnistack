package com.learn.dsa.basic.general;

public class CheckNumber {
    public static void main(String[] args) {
        // Test cases: 5, -3, 0
        System.out.println(checkNumber(5));
        System.out.println(checkNumber(-3));
        System.out.println(checkNumber(0));
    }

    private static String checkNumber(int num) {
    	if(num<0) {
    		return "negative";
    	}
    	else if(num>0) {
    		return "positive";
    	}
    	else
    	{
    		return "zero";
    	}

    }
}