package com.ddlab.rnd.thread3;
import java.util.concurrent.TimeUnit;

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
	
	public static synchronized void doTask3()
	{
		for( int i = 0 ; i < 5 ; i++ )
		{
			System.out.println("Thread Name in Task2 :::"+Thread.currentThread().getName());
			try 
			{
				System.out.println("Thread Name in Task2 Before Sleep:::"+Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Thread Name in Task2 After Sleep:::"+Thread.currentThread().getName());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println("Thread Name in Task2 After Try-Catch:::"+Thread.currentThread().getName());
		}
	}
}
