package exe3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Suspending implements Runnable {
	private static boolean flag = false;
	
	private String[] words = new String[]{ "It", "is", "recommended", "to", "use", "Calendar", "class" };
	
	public void SomeText()
	{
		String theWord="";
		int i=0;
		for(int c=0;c<10;c++)
		{
			if(i==words.length)
			{
				i=0;
			}
			theWord+=words[i]+" ";
			System.out.println(theWord);
			
			i++;
			
		}
			
	}
	public void DisplayText() {
		flag=true;
		String[] tempWords = words;
		Random rand = new Random();
		for(int j = 0;j<tempWords.length;j++) {
			int randomIndexToSwap = rand.nextInt(tempWords.length);
			String temp = tempWords[randomIndexToSwap];
			tempWords[randomIndexToSwap] = tempWords[j];
			tempWords[j] = temp;
		}
		System.out.println("\n"+Arrays.toString(tempWords));
		//flag=false;
	}
	
	public void DisplayText(String threadName) {
		String[] tempWords = words;
		Random rand = new Random();
		for(int j = 0;j<tempWords.length;j++) {
			
			if(flag) {
			try {
					System.out.println("\n\n"+ threadName + " is suspended\n\n");
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println("Thread Interupted!!");
			}
			flag=false;
			}
		
			
			int randomIndexToSwap = rand.nextInt(tempWords.length);
			String temp = tempWords[randomIndexToSwap];
			tempWords[randomIndexToSwap] = tempWords[j];
			tempWords[j] = temp;
		}
		System.out.println("\n"+Arrays.toString(tempWords));
		
	}
	
	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		if (currentThread.getName() == "text") {
			
			SomeText();
			
		}
		else if (currentThread.getName() == "word1" || currentThread.getName() == "word") {
			
			DisplayText();
			
		}
		else {
			DisplayText(currentThread.getName());
		}
	
	}
}


