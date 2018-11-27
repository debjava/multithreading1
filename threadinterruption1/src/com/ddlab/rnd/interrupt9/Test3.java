package com.ddlab.rnd.interrupt9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test3 {

	String str = "ABCDEFGHI";
	String nos = "123456789";
	
	public void runInThreads() throws Exception{
		long startTime = System.nanoTime();
		
		Callable<List<String>> strCallable = new StringCallable(str);
		Callable<List<String>> numCallable = new NumberCallable(nos);
		
		ExecutorService exService = Executors.newFixedThreadPool(2);
		Future<List<String>> strFuture = exService.submit(strCallable);
		Future<List<String>> numFuture = exService.submit(numCallable);
		exService.shutdown();
		while( !exService.isTerminated() ){}
		
		List<String> strList = strFuture.get();
		List<String> numList = numFuture.get();
		
		
		long endTime = System.nanoTime();
		long diffTime = endTime - startTime;

		double C3 = 1L * 1000L * 1000L * 1000L;
		double timeInSec = diffTime / C3;
		String headerStr = String.format("%-35s %-25s %-25s %-25s",
				"Type(Lock)", "Size", "Nanoseconds", "Seconds");
		System.out.println(headerStr);
		System.out
				.println("------------------------------------------------------------------------------------------------------");
		String formattedStr = String.format("%-35s %-25s %-25s %-25s",
				"String", strList.size(), diffTime, timeInSec);
		System.out.println(formattedStr);
		formattedStr = String.format("%-35s %-25s %-25s %-25s", "Number",
				numList.size(), diffTime, timeInSec);
		System.out.println(formattedStr);
	}
	public static void main(String[] args) throws Exception {
		new Test3().runInThreads();
	}

}
