package com.ddlab.rnd.interrupt8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {

	String str = "ABCDEFGH";
	String nos = "12345678";
	
	public void runInThreads(){
		long startTime = System.nanoTime();
		Permutation perm = new Permutation();
		
		List<String> strList = new CopyOnWriteArrayList<String>();
		List<String> nosList = new CopyOnWriteArrayList<String>();
		
		Thread strTh = new StringThread(perm, str, strList);
		strTh.setName("StringThread");
		Thread nosTh = new NumberThread(perm, nos, nosList);
		nosTh.setName("NumberThread");
		
		strTh.start();
		nosTh.start();
		
		boolean flag = true;
		while( flag ){
			if( !strTh.isAlive() & !nosTh.isAlive() ) flag = false;
		}
		String formatStr1 = String.format("%-30s %-30s", "Type","Result");
		System.out.println(formatStr1);
		String formatStr2 = String.format("%-30s %-30s", "String",strList.size());
		System.out.println(formatStr2);
		String formatStr3 = String.format("%-30s %-30s", "Number",nosList.size());
		System.out.println(formatStr3);
		
//		System.out.println(strList);
//		System.out.println(nosList);
		
		long endTime = System.nanoTime();
		long diffTime = endTime - startTime;
		
		System.out.println("Diff in Nanoseconds :::"+diffTime);
//		System.out.println("Diff in Seconds :::"+TimeUnit.NANOSECONDS.toSeconds(diffTime));
		double C3 = 1L * 1000L * 1000L * 1000L;
		double timeInSec = diffTime / C3;
		System.out.println("Actula Time In Seconds :::"+timeInSec);
	}
	
	public void runInThreads1(){
		long startTime = System.nanoTime();
		
		List<String> strList = new ArrayList<String>();
		List<String> nosList = new ArrayList<String>();
		
		Thread strTh = new StringThread(str, strList);
		strTh.setName("StringThread");
		Thread nosTh = new NumberThread(nos, nosList);
		nosTh.setName("NumberThread");
		
		strTh.start();
		nosTh.start();
		
		boolean flag = true;
		while( flag ){
			if( !strTh.isAlive() & !nosTh.isAlive() ) flag = false;
		}
		String formatStr1 = String.format("%-30s %-30s", "Type","Result");
		System.out.println(formatStr1);
		String formatStr2 = String.format("%-30s %-30s", "String",strList.size());
		System.out.println(formatStr2);
		String formatStr3 = String.format("%-30s %-30s", "Number",nosList.size());
		System.out.println(formatStr3);
		
//		System.out.println(strList);
//		System.out.println(nosList);
		
		long endTime = System.nanoTime();
		long diffTime = endTime - startTime;
		
		System.out.println("Diff in Nanoseconds :::"+diffTime);
//		System.out.println("Diff in Seconds :::"+TimeUnit.NANOSECONDS.toSeconds(diffTime));
		double C3 = 1L * 1000L * 1000L * 1000L;
		double timeInSec = diffTime / C3;
		System.out.println("Actula Time In Seconds :::"+timeInSec);
	}
	
	public void runSequential()
	{
		long startTime = System.nanoTime();
		Permutation perm = new Permutation();
		perm.getPermutation(str);
		perm.getPermutation(nos);
		long endTime = System.nanoTime();
		long diffTime = endTime - startTime;
		
		System.out.println("Diff in Nanoseconds :::"+diffTime);
		double C3 = 1L * 1000L * 1000L * 1000L;
		double timeInSec = diffTime / C3;
		System.out.println("Actula Time In Seconds :::"+timeInSec);
//		System.out.println("Diff in Seconds :::"+TimeUnit.NANOSECONDS.toSeconds(diffTime));
		
	}
	
	public void runInThreads2()
	{
		long startTime = System.nanoTime();
		
		
		List<String> strList = new CopyOnWriteArrayList<String>();
		List<String> nosList = new CopyOnWriteArrayList<String>();
		
		Thread strTh = new StringThread(str, strList);
		strTh.setName("StringThread");
		Thread nosTh = new NumberThread(nos, nosList);
		nosTh.setName("NumberThread");
		
		ExecutorService exService = Executors.newFixedThreadPool(2);
		exService.execute(strTh);
		exService.execute(nosTh);
		exService.shutdown();
		while( !exService.isTerminated() ){}
		
		
		
//		boolean flag = true;
//		while( flag ){
//			if( !strTh.isAlive() & !nosTh.isAlive() ) flag = false;
//		}
		String formatStr1 = String.format("%-30s %-30s", "Type","Result");
		System.out.println(formatStr1);
		String formatStr2 = String.format("%-30s %-30s", "String",strList.size());
		System.out.println(formatStr2);
		String formatStr3 = String.format("%-30s %-30s", "Number",nosList.size());
		System.out.println(formatStr3);
		
//		System.out.println(strList);
//		System.out.println(nosList);
		
		long endTime = System.nanoTime();
		long diffTime = endTime - startTime;
		
		System.out.println("Diff in Nanoseconds :::"+diffTime);
//		System.out.println("Diff in Seconds :::"+TimeUnit.NANOSECONDS.toSeconds(diffTime));
		double C3 = 1L * 1000L * 1000L * 1000L;
		double timeInSec = diffTime / C3;
		System.out.println("Actula Time In Seconds :::"+timeInSec);
	}
	
	public static void main(String[] args) {
		
//		new Test().runSequential();
		new Test().runInThreads();
//		new Test().runInThreads1();
//		new Test().runInThreads2();
		
	}

}
