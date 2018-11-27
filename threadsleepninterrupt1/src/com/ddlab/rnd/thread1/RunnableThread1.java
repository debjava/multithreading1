package com.ddlab.rnd.thread1;

public class RunnableThread1 implements Runnable 
{
	@Override
	public void run() 
	{
		for( int i = 0 ; i < 100 ; i++ )
		{
			System.out.println("I--->"+i);
			try 
			{
				Thread.sleep(1000);
			}
			catch (InterruptedException e) 
			{
				System.out.println("Thread has been intterupted, " +
				"it has not yet completed full tasks.");
				System.out.println("It is going out now.");
				e.printStackTrace();
				return;
			}
		}
		System.out.println("Successfully completed taks.");
	}
}
