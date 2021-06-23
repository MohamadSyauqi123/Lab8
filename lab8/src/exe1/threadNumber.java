package exe1;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class threadNumber extends Thread {
	public void printer (String currentThreadName)
	{
		LocalTime time = LocalTime.now();
		DateTimeFormatter timeFormat= DateTimeFormatter.ofPattern("HH:mm:ss");
		String fTime=time.format(timeFormat);
		
		for(int i=1;i<11;++i)
		{
			System.out.println(i+")"+currentThreadName+"at " + fTime);
		}
	}

	public void run()
	{
		Thread currentThread = Thread.currentThread();
		printer(currentThread.getName());
	}
}
