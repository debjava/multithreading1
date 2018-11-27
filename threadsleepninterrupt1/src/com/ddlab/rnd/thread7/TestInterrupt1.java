package com.ddlab.rnd.thread7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestInterrupt1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception 
	{
		
		Thread th1 = new Thread( new Thread1());
		Thread th2 = new Thread( new Thread2());
		
		ExecutorService exService1 = Executors.newCachedThreadPool();
		exService1.execute(th1);
		ExecutorService exService2 = Executors.newCachedThreadPool();
		exService2.execute(th2);
		
		exService1.shutdown();
		exService2.shutdown();
		
		boolean flag = true;
		while( flag )
		{
			if(Thread1.th1Counter == 5)
			{
				exService1.shutdownNow();
//				exService1.awaitTermination(0, TimeUnit.NANOSECONDS);
//				exService1.shutdown();
//				Thread.currentThread().interrupt();
//				th1.interrupt();
				System.out.println("Making a request to interrupt the thread1...");
				flag = false;
			}
		}
		
	}

}
