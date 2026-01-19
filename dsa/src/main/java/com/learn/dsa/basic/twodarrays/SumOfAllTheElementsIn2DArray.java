package com.learn.dsa.basic.twodarrays;

public class SumOfAllTheElementsIn2DArray {

	public static void main(String[] args) {
		int[][] twodArry= new int[3][2];
		twodArry = new int[][] {{1,2},{6,7},{12,-4}};
		int sum=0;
		for(int i=0;i<twodArry.length;i++) {
			for(int j=0;j<twodArry[i].length;j++) {
				System.out.print(twodArry[i][j]+", ");
			sum +=twodArry[i][j];
			}
		}
		System.out.println(sum);

	}

}
