package com.ddlab.rnd.thread3;

import java.util.concurrent.TimeUnit;

public class CommonUtil1 
{
	public void doIt1()
	{
		synchronized( this )
		{
			for( int i = 0 ; i < 5 ; i++ )
			{
				System.out.println("Thread Name :::"+Thread.currentThread().getName());
				try 
				{
					TimeUnit.SECONDS.sleep(1);
					doIt2();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
//		doIt2();
	}
	
	public synchronized void doIt2()
	{
		System.out.println("--------------- Method : doIt2() ---------------");
		for( int i = 0 ; i < 5 ; i++ )
		{
			System.out.println("Thread Name :::"+Thread.currentThread().getName());
			try 
			{
				TimeUnit.SECONDS.sleep(2);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
