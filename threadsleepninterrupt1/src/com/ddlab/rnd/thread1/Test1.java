package com.ddlab.rnd.thread1;
public class Test1 
{
	public static void main(String[] args) throws Exception
	{
		Thread th1 = new Thread( new RunnableThread1());
		th1.start();
		
		Thread.sleep(3000);
		
		th1.interrupt();

	}

}
