package com.ddlab.rnd.thread4;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.sql.rowset.Joinable;

public class CommonUtil2
{
	public static void doTask1()
	{
		for( int i = 0 ; i < 5 ; i++ )
		{
			System.out.println("Thread Name in Task1 :::"+Thread.currentThread().getName());
			try 
			{
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void doTask2()
	{
		for( int i = 0 ; i < 5 ; i++ )
		{
			System.out.println("Thread Name in Task2 :::"+Thread.currentThread().getName());
			try 
			{
				TimeUnit.SECONDS.sleep(1);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static void doTask3()
	{
		synchronized( CommonUtil2.class )
		{
			for( int i = 0 ; i < 5 ; i++ )
			{
				System.out.println("**********************"+i+"**********************");
				System.out.println("Thread Name in Task3 :::"+Thread.currentThread().getName());
				try 
				{
					System.out.println("Thread Name in Task3 Before Sleep:::"+Thread.currentThread().getName());
					TimeUnit.SECONDS.sleep(1);
					System.out.println("Thread Name in Task3 After Sleep:::"+Thread.currentThread().getName());
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("Thread Name in Task3 After Try-Catch:::"+Thread.currentThread().getName());
			}
		}
	}
//	Lock lock = new ReentrantLock();
	public synchronized void doTask4() throws Exception
	{
//		lock.tryLock();
		for( int i = 0 ; i < 5; i++ )
		{
			
			System.out.println("**********************"+i+" : "+Thread.currentThread().getName()+"**********************");
			System.out.println("Thread Name :::"+Thread.currentThread().getName());
			try 
			{
				
				System.out.println("Thread Name Before Sleep:::"+Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Thread Name After Sleep:::"+Thread.currentThread().getName());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("Thread Name After Try-Catch:::"+Thread.currentThread().getName());
		}
//		lock.unlock();
	}

	private int c = 0;
	public synchronized int getValue()
	{
		for( int i = 0 ; i < 5; i++ )
		{
			System.out.println("**********************"+i+" : "+Thread.currentThread().getName()+"**********************");
			System.out.println("Thread Name :::"+Thread.currentThread().getName());
			try 
			{
				System.out.println("Thread Name Before Sleep:::"+Thread.currentThread().getName());
				c++;
				System.out.println("Value of C--->"+c);
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Thread Name After Sleep:::"+Thread.currentThread().getName());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			System.out.println("Thread Name After Try-Catch:::"+Thread.currentThread().getName());
		}
		return c;
	}
}
