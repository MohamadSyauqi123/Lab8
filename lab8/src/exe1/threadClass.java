package exe1;

public class threadClass {
	
public static void main(String args[]) {
	//thread object
	Thread T1 = new threadNumber();
	Thread T2 = new threadNumber();
	
	T1.setName("Thread 1");
	T2.setName("Thread 2");
	
	T1.start();
	T2.start();
	
	
}
}
