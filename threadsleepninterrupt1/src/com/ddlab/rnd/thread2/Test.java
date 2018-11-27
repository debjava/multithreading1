package com.ddlab.rnd.thread2;

public class Test 
{
	public static void main(String[] args) 
	{
		Counter count = new Counter();
		
		Thread a = new Thread( new ThreadA(count));
		Thread b = new Thread( new ThreadB(count));
		
		a.start();
		b.start();
		
		
//		count.decrement();
//		System.out.println("Decremented Value : "+count.value());
//		count.increment();
//		System.out.println("Incremented Value : "+count.value());
		
	}

}
