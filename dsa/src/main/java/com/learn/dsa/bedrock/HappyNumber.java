package com.learn.dsa.bedrock;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		
		int n=19;

System.out.println(happyNumber(n));

	}
	public static boolean happyNumber(int n) {
		Set<Integer> seen= new HashSet<>();
		
		while(checkDuplicates(n,seen)) {
			if(n==1) {
				return true;
			}
		 n=digitExtractor(n);
		 
		}
		return false;
	}
	
	public static int digitExtractor(int n) {
		/**
		 * n=191
		 * n%10== 1
		 * n/10== 19
		 */
		//n=3456789;
		int sum=0;
		while(n > 0) {
			int digit = n%10;
			digit= digit*digit;
			sum+=digit;
			n=n/10;
		}
		System.out.println(sum);
		return sum;
	}
	
	public static boolean checkDuplicates(int r, Set<Integer> s) {
		//r= new int[] {1,3,4,5,6,8};
		
		
		//for(int i=0;i<r.length;i++) {
		if(!s.add(r)) {
			return true; 
		}
		//}
		return false;
	}

}
