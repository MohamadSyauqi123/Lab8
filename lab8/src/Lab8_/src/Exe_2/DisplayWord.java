package Exe_2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


	
	
	
	
	public class DisplayWord implements Runnable {

		// create the array with these words
		private String[] words = new String[]{ "It", "is", "recommended", "to", "use", "Calendar", "class" };
		
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
		 */
		public void displayWordsRandomly() {
			
			String[] tempWords = words;
			Random rand = new Random();
			for(int i = 0;i<tempWords.length;i++) {
				int randomIndexToSwap = rand.nextInt(tempWords.length);
				String temp = tempWords[randomIndexToSwap];
				tempWords[randomIndexToSwap] = tempWords[i];
				tempWords[i] = temp;
			}
			System.out.println("\n"+Arrays.toString(tempWords));
			
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
				System.out.println("no where inside");
			}
			
		}

	}



