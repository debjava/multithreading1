package com.ddlab.rnd.thread8;

import java.util.concurrent.TimeUnit;

public class Thread2 implements Runnable 
{
	public static int th2Counter = 0 ;
	
	@Override
	public void run() {
		for( int i = 0 ; i < 20 ; i++ )
		{
			try {
				
				System.out.println("Thread2--->"+i);
				TimeUnit.SECONDS.sleep(1);
			}
			catch( InterruptedException ie )
			{
				Thread.currentThread().interrupt();
				return;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
