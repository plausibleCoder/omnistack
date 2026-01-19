package com.learn.java.corejava.learn.collectionframework.generics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Book{
	private String bookName;
	private String bookId;
	private String author;
	
	Book(String bookName, String bookId, String author){
		this.author= author;
		this.bookId=bookId;
		this.bookName=bookName;
	}
}

class Animal{
	private String animalName;
	private String breed;
}

public class TestCollections {

	public static void main(String[] args) {
		
		List<Book> books= new ArrayList<>();
		books.add(new Book("abc","1","Karthik"));
		books.add(new Book("abc","1","Grishma"));
		books.add(new Book("abc","1","Priya"));
		
		Map<String, Book> authorBook= new  HashMap<>();
		
		authorBook.put("Karthik", new Book("abc","1","Karthik"));
	}

}
