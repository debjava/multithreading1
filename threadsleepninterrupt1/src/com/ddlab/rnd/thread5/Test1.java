package com.ddlab.rnd.thread5;

import java.util.concurrent.TimeUnit;

public class Test1 {

	public static void doMultithreading1()
	{
		Common cmn = new Common();
		try 
		{
			long startTime = System.nanoTime();
			Thread th1 = new Thread( new Thread1(cmn) );
			th1.setName("T1");
			Thread th2 = new Thread( new Thread2(cmn) );
			th2.setName("T2");
			
			//Always write join() method after the start() method of a thread
			th1.start();
			th2.start();
			
//			 System.out.println(th2.getState());
			
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
	
	public static void main(String[] args) {
		doMultithreading1();
	}

}
