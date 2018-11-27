package com.ddlab.rnd.thread3;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class CommonUtil 
{
	
	public static void doIt1()
	{
		synchronized( CommonUtil.class )
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
	
	public static synchronized void doIt2()
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
	
//	public static int factorial( int num )
//	{
//		if( num == 0 ) return 1;
//		num = num * factorial(num - 1);
//		return num;
//	}
//	
//	public static BigInteger factorial( BigInteger num )
//	{
//		if( num.equals(new BigInteger("0")) ) return new BigInteger("1");
//		num = num.multiply( factorial(num = (num.subtract( new BigInteger("1")))) );
//		return num;
//	}
	
//	public static void main(String[] args) 
//	{
////		System.out.println(factorial(10));
////		BigInteger bigInt = new BigInteger("1234567987654321");
////		System.out.println( factorial(bigInt));
////		BigInteger i = new BigInteger("1");
////		System.out.println(i);
////		i = i.add(new BigInteger("1"));
////		System.out.println(i);
//		BigInteger n = new BigInteger("1915");
//		for( BigInteger i = new BigInteger("1") ; i.compareTo(n) == -1 ; i=i.add( new BigInteger("1")) )
//		{
//			System.out.println("Value--->"+i);
//			System.out.println(factorial(i));
//		}
//		
////		System.out.println(n.multiply(n));
//		
//	}
}
