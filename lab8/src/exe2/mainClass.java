package exe2;


public class mainClass {
	public static void main (String args[]) {
		Runnable display1 = new displayWords();
		Runnable display2 = new displayWords();
		
		
		
		Thread DT3 = new Thread(display1,"text");
		Thread DT4 = new Thread(display2,"word1");
		
		
		DT3.start();
		DT4.start();
	
		
	}

}
