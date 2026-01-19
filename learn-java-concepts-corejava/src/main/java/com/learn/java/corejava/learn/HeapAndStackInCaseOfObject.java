package com.learn.java.corejava.learn;


class Student {
	int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
public class HeapAndStackInCaseOfObject {
	

	public static void main(String[] args) {
		
		// Assuming a 'Student' class with an 'id' variable
		Student st1 = new Student(); // st1 points to Student Object A
		Student st2 = new Student(); // st2 points to Student Object B

		// Let's set the id for each object
		st1.id = 1; 
		st2.id = 2; 

		st1 = st2; // st1 now points to the same object as st2 (Student Object B)

		System.out.println(st1.id); // Prints 2
		System.out.println(st2.id); // Prints 2

		// Now if we change the id via st1
		st1.id = 3;

		System.out.println(st1.id); // Prints 3
		System.out.println(st2.id); // Also prints 3, because they point to the same object
	}
	

}
