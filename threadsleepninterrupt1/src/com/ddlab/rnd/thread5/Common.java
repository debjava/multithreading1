package com.ddlab.rnd.thread5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Common 
{
	private AtomicInteger ai = new AtomicInteger(0);

	public void doTask1()
	{
		String s1 = String.format("%-20s %-10s %-20s %-30s %-10s",
				"Method name", "Counter", "Thread Name", "Time in nanoseconds",
				"Value");
		System.out.println(s1);
		try 
		{
			for( int i = 0 ; i < 5 ; i++ )
			{
				String s = String.format("%-20s %-10s %-20s %-30s %-10s",
						"doTask1()", i, Thread.currentThread().getName(),
						System.nanoTime(), ai.incrementAndGet());
				TimeUnit.SECONDS.sleep(1);
				System.out.println(s);
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void doTask2()
	{
		String s1 = String.format("%-20s %-10s %-20s %-30s %-10s",
				"Method name", "Counter", "Thread Name", "Time in nanoseconds",
				"Value");
		System.out.println(s1);
		try 
		{
			for( int i = 0 ; i < 5 ; i++ )
			{
				String s = String.format("%-20s %-10s %-20s %-30s %-10s",
						"doTask2()", i, Thread.currentThread().getName(),
						System.nanoTime(), ai.incrementAndGet());
				TimeUnit.SECONDS.sleep(1);
				System.out.println(s);
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
