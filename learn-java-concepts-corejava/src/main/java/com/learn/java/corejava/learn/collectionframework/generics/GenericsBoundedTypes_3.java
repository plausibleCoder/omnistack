package com.learn.java.corejava.learn.collectionframework.generics;

public class GenericsBoundedTypes_3 {
	
	 public static <T extends Number> double getAverage(T[] numbers) {
	        double sum = 0.0;
	        for (T number : numbers) {
	            sum += number.doubleValue();
	        }
	        return sum / numbers.length;
	    }

}

class BoundedTypeExample {
    public static void main(String[] args) {
        Integer[] integers = {1, 2, 3, 4, 5};
        Double[] doubles = {1.5, 2.5, 3.5};
        String[] string = {"one","Two","Three"};
        System.out.println("Average of integers: " + GenericsBoundedTypes_3.getAverage(integers));
        System.out.println("Average of doubles: " + GenericsBoundedTypes_3.getAverage(doubles));
       // GenericsBoundedTypes_3.getAverage(string));
    }
    
   /*
    Select 
    Groupby
    Having 
    joins
    Where */
    
    
}
