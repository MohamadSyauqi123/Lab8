
package Exe_1;

public class Main {


	public static void main(String[] args) {
		
		// create 2 thread 
		Thread displayTimeThread1 = new DisplayTime();
		Thread displayTimeThread2 = new DisplayTime();
		
		// name them
		displayTimeThread1.setName("Thread1");
		displayTimeThread2.setName("Thread2");
		
		// start them
		displayTimeThread1.start();
		displayTimeThread2.start();
	}
}

