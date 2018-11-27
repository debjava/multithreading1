package com.ddlab.rnd.interrupt4;

import java.util.concurrent.TimeUnit;

public class MyUtil {
	
	public synchronized void execute()
	{
		recursiveIncrement(0);
	}
	
	public void recursiveIncrement( int num )
	{
		try {
			Thread currentThread = Thread.currentThread();
			num++;
			if( num >= 100 ) return;
			else{
				
				String msg = String.format("%-30s %-20s", currentThread.getName(),num);
				System.out.println(msg);
				if( num == 37 && currentThread.getName().equals("Thread-1")) {
					System.out.println("\nNow the value is received and the loop should be stopped...");
					currentThread.interrupt();
					return;//This is my interruption policy
				}
				TimeUnit.MILLISECONDS.sleep(50);
				recursiveIncrement( num );
			}
		}
		catch( InterruptedException ie ){
			ie.printStackTrace();
			//The interrupt status flag is cleared, so it will continue
			num = 110;
			System.out.println("Now Num value---->"+num);
			System.out.println("Thread Interrupt status --->"+Thread.currentThread().isInterrupted());
			Thread.currentThread().interrupt();
			System.out.println("Thread Interrupt status --->"+Thread.currentThread().isInterrupted());
			return;
		}
		catch (Exception e) {
			System.out.println("Other Exception ....");
			e.printStackTrace();
		}
	}


}
