package com.learn.dsa.bedrock;

public class SumArray {

//     Write a Java method public static int sumArray(int[] arr) that calculates the sum of all the integers in an array.

// If the array is empty or null, it should return 0.

public static void main(String[] args){
    int[] arr={2,4,6,-1,98};
    System.out.println(sumArray(arr));

}

public static int sumArray(int[] arr){
    int sum=0;
    if((arr==null)|| (arr.length == 0) ){
        return 0;
    }
    else{
        for(int i=0;i<arr.length;i++){
             sum+=arr[i];
        }
    }
    return sum;
}
    
}
