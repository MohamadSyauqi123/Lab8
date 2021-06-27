package Exe_1;

public class DisplayTime extends Thread{
	
	/*
	 * This method will display [ thread_name : (current_time) ]
	 * @param currentThread the thread name
	 */
	public void displayTime(String currentThread) {
		
		for (int counter = 0; counter< 10 ; counter++) {
			
			System.out.println(currentThread +" : "+ java.time.LocalTime.now());
			
		}
	}
	
	/*
	 * This method will add the thread to the task when it started
	 */
	public void run() {
		
		Thread currentThread = Thread.currentThread();
		displayTime(currentThread.getName());
		
	}

}
