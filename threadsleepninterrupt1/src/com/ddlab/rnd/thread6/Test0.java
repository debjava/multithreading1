package com.ddlab.rnd.thread6;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test0 
{
	public static void main(String[] args) throws Exception
	{
//		Callable<Integer> callable = new MyCallable();
//		ExecutorService executorService = Executors.newCachedThreadPool();
//		Future<Integer> future = executorService.submit(callable);
//		executorService.shutdown();
//		while( !executorService.isTerminated() ){}
//		System.out.println("Future value: " + future.get());
		
		//For two callable tasks
		Callable<Integer> callable1 = new MyCallable();
		Callable<Integer> callable2 = new MyCallable1();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		Future<Integer> future1 = executorService.submit(callable1);
//		if(future1.isDone())
			
		Future<Integer> future2 = executorService.submit(callable2);
//		if(future2.isDone())
			
		executorService.shutdown();
		while( !executorService.isTerminated() ){}
		System.out.println("Future1 value: " + future1.get());
		System.out.println("Future2 value: " + future2.get());
		
		
	}

}
