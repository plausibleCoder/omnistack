package com.learn.java.corejava.learn.hasarelationship;


public class HasARelationship extends  Karthik {
	
	HasARelationship(){
		System.out.println("Hi Karthik");
	}
	
	HasARelationship karthik = new HasARelationship();
}

interface MyArchitectInterface{
	
	public int checkTheBalance();
	public int deductTheAmount();
	public void doThePayment();
	
	
}

interface MyGooglePayArchitect{
	
}

interface phonePeArchitect{
	public int checkThePhonePeBalance();
}
class Karthik implements MyArchitectInterface,MyGooglePayArchitect, phonePeArchitect{


	public int checkTheBalance() {
		return 0;
	}


	public int deductTheAmount() {
		return 0;
	}


	public void doThePayment() {
		
	}


	public int checkThePhonePeBalance() {
		return 0;
	}
	
	public int m1() {
		return 0;
		
	}
	
}

class Parent2{
	
	public int m1() {
		return 0;
		
	}
	
}

