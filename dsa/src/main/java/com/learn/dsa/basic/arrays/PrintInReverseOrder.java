package com.learn.dsa.basic.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

//Given an array, print all its elements in reverse order.
public class PrintInReverseOrder {

	int[] arr= {23,67,90,-1,96,100,64};
	public static void main(String [] args) {
		PrintInReverseOrder obj= new PrintInReverseOrder();
		int[] rev=obj.printInReverseOrder();
		for(int i=0;i<rev.length;i++) {
			//System.out.println(rev[i]);
		}
		int[] rev2 = obj.printInReverseOrderUsingStreams();
        for (int i = 0; i < rev2.length; i++) {
            System.out.println(rev2[i]);
        }
		
	}
	private int[] printInReverseOrder() {
		int[] rev=new int[arr.length];
		int j=0;
		for(int i=arr.length-1; i>=0;i--) {
			rev[j]=arr[i];
			j++;
		}
		return rev;
		
	}
	
	private int[] printInReverseOrderUsingStreams() {
		return IntStream.range(0, arr.length).map(i -> arr[arr.length-1 -i]).toArray();
		
	}
}
