package com.learn.dsa.basic.twodarrays;

public class NonSortedArrayBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean search (int[][] mat, int target) {
		
		int col = mat[0].length-1;
		int row=0;
		while(row >= mat.length &&col<0) {
			if(mat[row][col]>target) {
				col=col-1;
				
			}
			else {
				row=row+1;
			}
		}
		return false;
		
	}
}
