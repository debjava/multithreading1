package com.ddlab.rnd.thread5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test0 
{
	public static void doMultithreading1()
	{
		try 
		{
			long startTime = System.nanoTime();
			Thread th1 = new Thread( new Thread1() );
			th1.setName("T1");
			Thread th2 = new Thread( new Thread2() );
			th2.setName("T2");
			
			//Always write join() method after the start() method of a thread
			th1.start();
			th1.join();
			th2.start();
			th2.join();
			
			//This is wrong to write
//			th1.join();
//			th2.join();
			
			boolean flag = true;
			while( flag )
			{
				if( !th1.isAlive() && !th2.isAlive())
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
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public static void doMultithreading2()
	{
		try {
			Runnable th1 = new Thread1() ;
			ExecutorService service1 = Executors.newSingleThreadExecutor();
			service1.execute(th1);
			service1.shutdown();
			while( !service1.isTerminated() ){}
			Runnable th2 = new Thread2() ;
			ExecutorService service2 = Executors.newSingleThreadExecutor();
			service2.execute(th2);
			service2.shutdown();
			while( !service2.isTerminated() ){}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		doMultithreading2();
	}

}
