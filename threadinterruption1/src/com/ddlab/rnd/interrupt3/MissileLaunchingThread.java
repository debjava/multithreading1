package com.ddlab.rnd.interrupt3;
import java.util.concurrent.TimeUnit;

public class MissileLaunchingThread extends Thread
{
	@Override
	public void run() {
		String header = String.format("%-30s %-20s", "Thread Name","Counter");
		System.out.println(header);
		for( int i = 0 ; i < 100 ; i++ )
		{
			try {
				Thread currentThread = Thread.currentThread();
				String msg = String.format("%-30s %-20s", currentThread.getName(),i);
				System.out.println(msg);
				if( i == 87 ) {
					System.out.println("\nNow the value is received and the loop should be stopped...");
					currentThread.interrupt();
					System.out.println("Thread has been interrupted...");
					System.out.println("Can I be stopped ?????????");
					System.out.println("No way BOSS... I am going to be fired....");
				}
				TimeUnit.MILLISECONDS.sleep(10);
			}
			catch( InterruptedException ie )
			{
				ie.printStackTrace();
				//The interrupt status flag is cleared, so it will continue
				System.out.println("Thread Interrupt status --->"+Thread.currentThread().isInterrupted());
				Thread.currentThread().interrupt();
				System.out.println("Thread Interrupt status --->"+Thread.currentThread().isInterrupted());
				break;//This is my interruption policy
//				return;//This is my interruption policy
			}
			catch (Exception e) {
				System.out.println("Other Exception ....");
				e.printStackTrace();
			}
		}
	}
	
//	@Override
	public void interrupt() {
		System.out.println("********** I WILL NOT BE STOPPED OR INTERRUPTED *****************");
		System.out.println("********** I WILL NOT BE STOPPED OR INTERRUPTED *****************");
		System.out.println("********** I WILL NOT BE STOPPED OR INTERRUPTED *****************");
	}
}
