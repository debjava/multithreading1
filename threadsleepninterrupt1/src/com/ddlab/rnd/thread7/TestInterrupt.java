package com.ddlab.rnd.thread7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestInterrupt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread th1 = new Thread( new Thread1());
		Thread th2 = new Thread( new Thread2());
		
		ExecutorService exService = Executors.newCachedThreadPool();
		exService.execute(th1);
		exService.execute(th2);
		
		exService.shutdown();
		
		boolean flag = true;
		while( flag )
		{
			if(Thread1.th1Counter == 5)
			{
//				exService.shutdownNow();
				th1.interrupt();
				System.out.println("Making a request to interrupt the thread1...");
				flag = false;
			}
		}
		
	}

}
