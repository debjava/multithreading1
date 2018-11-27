package com.ddlab.rnd.interrupt9;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

	String str = "ABCDEFGHI";
	String nos = "123456789";
	
	public void runInThreads(){
		long startTime = System.nanoTime();
		
		List<String> strList = new ArrayList<String>();
		List<String> numList = new ArrayList<String>();
		
		Thread strTh = new StringThread(str, strList);
		strTh.setName("StringThread");
		Thread nosTh = new NumberThread(nos, numList);
		nosTh.setName("NumberThread");
		
		strTh.start();
		nosTh.start();
		
		boolean flag = true;
		while( flag ){
			if( !strTh.isAlive() & !nosTh.isAlive() ) flag = false;
		}
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
	public static void main(String[] args) {
		new Test2().runInThreads();
	}

}
