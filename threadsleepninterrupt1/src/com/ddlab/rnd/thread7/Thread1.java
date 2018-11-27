package com.ddlab.rnd.thread7;

import java.util.concurrent.TimeUnit;

public class Thread1 implements Runnable 
{
	public static int th1Counter = 0 ;
	@Override
	public void run() {
		for( int i = 0 ; i < 20 ; i++ )
		{
			try {
				if( Thread.currentThread().isInterrupted() )
					break;
//				if( i == 9 ) Thread.currentThread().interrupt();
				System.out.println("Thread1--->"+i);
				th1Counter = i;
				TimeUnit.SECONDS.sleep(1);
			}
			catch( InterruptedException ie )
			{
				System.out.println("Thread has been interrupted....");
				ie.printStackTrace();
				Thread.currentThread().interrupt();
				return;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
