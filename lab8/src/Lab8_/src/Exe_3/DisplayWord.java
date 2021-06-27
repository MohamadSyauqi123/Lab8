package Exe_3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class DisplayWord implements Runnable{
	
	// create the array with these words
		private String[] words = new String[]{ "It", "is", "recommended", "to", "use", "Calendar", "class" };
		private static boolean suspendFlag = false;
		
		/*
		 * This method will display the array words for 10 times. 
		 * each time it will increase the index to display.
		 * step 1(d)
		 */
		public void displayPortionsOfText() {
			
			String output = "";
			int counter = 0, index = 0;
			while(counter < 10) {
				
				if(index == words.length ) {
					index = 0;
				}
					
				output += words[index] +" ";
				
				System.out.println(output);
				
				counter++;
				index++;
			}
		}
		
		/*
		 * this class will shuffle the array words and display it.
		 * step 1(e)
		 * 
		 * will triggered the flag when executing
		 */
		public void displayWordsRandomly() {
			
			suspendFlag = true;
			String[] tempWords = words;
			Random rand = new Random();
			for(int i = 0;i<tempWords.length;i++) {
				int randomIndexToSwap = rand.nextInt(tempWords.length);
				String temp = tempWords[randomIndexToSwap];
				tempWords[randomIndexToSwap] = tempWords[i];
				tempWords[i] = temp;
			}
			System.out.println("\n"+Arrays.toString(tempWords));
			suspendFlag = false;
			
		}
		
		
		/*
		 * @override
		 * @param threadName
		 * when the flag triggered then it will sleep for 5 seconds
		 */
		public void displayWordsRandomly(String threadName) {
			
			
			String[] tempWords = words;
			Random rand = new Random();
			for(int i = 0;i<tempWords.length;i++) {
				synchronized(this) {
					if(suspendFlag) {
						try {
							System.out.println("\n---"+threadName+"--- is sleeping for 5 sec");
							wait(5000);
							System.out.println("\n---"+threadName+"--- is working back");
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						suspendFlag = false;
					}
				}
				int randomIndexToSwap = rand.nextInt(tempWords.length);
				String temp = tempWords[randomIndexToSwap];
				tempWords[randomIndexToSwap] = tempWords[i];
				tempWords[i] = temp;
			}
			System.out.println(Arrays.toString(tempWords));
		}
		
		
		/*
		 * this method will run the thread base the name assigned.
		 * 
		 */
		public void run() {
			// TODO Auto-generated method stub
			
			Thread currentThread = Thread.currentThread();
			if (currentThread.getName() == "text") {
				
				displayPortionsOfText();
				
			}
			else if (currentThread.getName() == "word1" || currentThread.getName() == "word2") {
				
				displayWordsRandomly();
				
			}
			else {
				displayWordsRandomly(currentThread.getName());
			}
			
		}

}
