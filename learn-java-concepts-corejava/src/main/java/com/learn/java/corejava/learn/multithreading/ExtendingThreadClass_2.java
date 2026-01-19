package com.learn.java.corejava.learn.multithreading;

public class ExtendingThreadClass_2 {
	
	public static void main(String[] args) {
		ThreadDemo t = new ThreadDemo();
		t.start();
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread");
			try {
				t.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

class ThreadDemo extends Thread{
	
	public void run() {
		for(int i=0;i<10; i++) {
			System.out.println("Child Thread");
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
