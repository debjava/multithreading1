package com.ddlab.rnd.interrupt7;

import java.util.concurrent.TimeUnit;

public class TestSnippet1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		CommonUtil util = new CommonUtil();
		
		Thread th1 = new Thread1(util);
		Thread th2 = new Thread2(util);
		th1.setName("Thread-1");
		th2.setName("Thread-2");
		th1.start();
		th2.start();
		boolean flag = true;
		th2.interrupt();
		while( flag ){
			if( !th1.isAlive() & !th2.isAlive() ) flag = false;
		}
		long endTime = System.nanoTime();
		long diffTime = endTime - startTime;
		System.out.printf("%-30s %-30s %-30s %-30s %-30s %n","Result ","Nanoseconds","Microsecond","Millisecond","Seconds");
		System.out.printf("%-30s %-30s %-30s %-30s %-30s", "Result ", diffTime,
				TimeUnit.NANOSECONDS.toMicros(diffTime),
				TimeUnit.NANOSECONDS.toMillis(diffTime),
				TimeUnit.NANOSECONDS.toSeconds(diffTime));
		
	}

}
