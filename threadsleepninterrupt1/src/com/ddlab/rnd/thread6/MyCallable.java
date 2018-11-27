package com.ddlab.rnd.thread6;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<Integer> 
{
	@Override
	public Integer call() throws Exception {
		String s1 = String.format("%-20s %-10s %-20s %-30s %-10s",
				"Method name", "Counter", "Thread Name", "Time in nanoseconds",
				"Value");
		System.out.println(s1);
		int tempValue = 0;
		for( int i = 0 ; i < 5 ; i++ )
		{
			tempValue = tempValue+i;
			TimeUnit.SECONDS.sleep(1);
			String s = String.format("%-20s %-10s %-20s %-30s %-10s",
					"doTask1()", i, Thread.currentThread().getName(),
					System.nanoTime(), tempValue);
			System.out.println(s);
		}
		return new Integer( tempValue );
	}
}
