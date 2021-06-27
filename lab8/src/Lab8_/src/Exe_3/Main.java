package Exe_3;

public class Main {
	

		public static void main (String[] args) {
			
			// create object
			Runnable displayWords1 = new DisplayWord();
			Runnable displayWords2 = new DisplayWord();
			Runnable displayWords3 = new DisplayWord();
			
			// name it
			Thread displayThread1 = new Thread(displayWords1, "Text");
			Thread displayThread2 = new Thread(displayWords2, "Word1");
			Thread displayThread3 = new Thread(displayWords2, "Word3");
			
			// start it
			displayThread1.start();
			displayThread2.start();
			displayThread3.start();
		}
	}


