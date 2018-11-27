package com.ddlab.rnd.thread4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test1 
{
	public static void doMultithreading() throws Exception
	{
		long startTime = System.nanoTime();
		Thread a = new Thread( new Thread1());
		a.setName("T1");
		Thread b = new Thread( new Thread2());
		b.setName("T2");
		a.start();
		b.start();
		
		
		boolean flag = true;
		while( flag )
		{
			if( !a.isAlive() && !b.isAlive())
			{
				System.out.println("All threads are dead....");
				flag = false;
				long endTime = System.nanoTime();
				long timeDiff = endTime - startTime;
				System.out.println("Time Difference :::"+timeDiff+" nano seconds");
				System.out.println("Time Difference :::"+TimeUnit.NANOSECONDS.toSeconds(timeDiff)+" seconds");
			}
		}
	}
	
	public static void doMultithreading1()
	{
		Runnable thread1 = new Thread1();
		Runnable thread2 = new Thread2();

		long startTime = System.nanoTime();
		//		ExecutorService executorService = Executors.newSingleThreadExecutor();
		//		ExecutorService executorService = Executors.newFixedThreadPool(2);
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(thread1);
		executorService.execute(thread2);

		executorService.shutdown();
		while (!executorService.isTerminated()) { } 

		System.out.println("Executor completed all the tasks, let us define a new one");
		long endTime = System.nanoTime();
		long timeDiff = endTime - startTime;
		System.out.println("Time Difference :::"+timeDiff+" nano seconds");
		System.out.println("Time Difference :::"+TimeUnit.NANOSECONDS.toSeconds(timeDiff)+" seconds");
	}
	
	public static void doMultithreading2() throws Exception
	{
		CommonUtil2 util = new CommonUtil2();
		long startTime = System.nanoTime();
		Thread a = new Thread( new Thread1(util));
		a.setName("T1");
		Thread b = new Thread( new Thread2(util));
		b.setName("T2");
		a.start();
		b.start();
		
//		a.join();
//		b.join();
		
		
		boolean flag = true;
		while( flag )
		{
			if( !a.isAlive() && !b.isAlive())
			{
				System.out.println("All threads are dead....");
				flag = false;
				long endTime = System.nanoTime();
				long timeDiff = endTime - startTime;
				System.out.println("Time Difference :::"+timeDiff+" nano seconds");
				System.out.println("Time Difference :::"+TimeUnit.NANOSECONDS.toSeconds(timeDiff)+" seconds");
			}
		}
	}


	public static void main(String[] args) throws Exception
	{
//		doMultithreading();
//		doMultithreading1();
		doMultithreading2();
	}
	
}
