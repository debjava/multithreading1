package com.ddlab.rnd.thread2;

public class ThreadB implements Runnable
{
	private Counter count; 
	public ThreadB( Counter count )
	{
		this.count = count;
	}
	@Override
	public void run() 
	{
		System.out.println("Thread B , initial Value ->"+count.value());
		count.decrement();
		System.out.println("Decremented Value :::"+count.value());
	}
}
