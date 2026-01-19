package com.learn.java.corejava.learn.collectionframework.generics;


class StringBox{
	
	private String item;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}
	
}

class GenericBox<T>{
	private T item;
	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
}



public class GerericsInClasses_1 {

	public static void main(String[] args) {
		
		StringBox b= new StringBox();
		b.setItem("Hello");
		//b.setItem(23);
		
		
	
		GenericBox<String> stringBox = new GenericBox<>();
        stringBox.setItem("Hello Generics!");
        System.out.println("The string is: " + stringBox.getItem());


        GenericBox<Integer> integerBox = new GenericBox<>();
        integerBox.setItem(123);
        System.out.println("The integer is: " + integerBox.getItem());

		
	}
	

}
