package com.ddlab.rnd.thread2;

public class ThreadA implements Runnable
{
	private Counter count; 
	public ThreadA( Counter count )
	{
		this.count = count;
	}
	@Override
	public void run() 
	{
		System.out.println("Thread A , initial Value ->"+count.value());
		count.increment();
		System.out.println("Incremented Value :::"+count.value());
	}
}
