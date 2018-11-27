package com.ddlab.rnd.interrupt9;

import java.util.List;

public class Test1 {
	private String str = "ABCDEFGH";
	private String nos = "12345678";

	public void runSequential() {
		long startTime = System.nanoTime();
		Permutation perm = new Permutation();
		List<String> strList = perm.getPermutation(str);
		List<String> numList = perm.getPermutation(nos);
		long endTime = System.nanoTime();
		long diffTime = endTime - startTime;

		double C3 = 1L * 1000L * 1000L * 1000L;
		double timeInSec = diffTime / C3;
		String headerStr = String.format("%-35s %-25s %-25s %-25s",
				"Type(Normal)", "Size", "Nanoseconds", "Seconds");
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

	public void runSequential1() {
		long startTime = System.nanoTime();
		Permutation perm = new Permutation();
		List<String> strList = perm.getPermutationWithSynch(str);
		List<String> numList = perm.getPermutationWithSynch(nos);
		long endTime = System.nanoTime();
		long diffTime = endTime - startTime;

		double C3 = 1L * 1000L * 1000L * 1000L;
		double timeInSec = diffTime / C3;
		String headerStr = String.format("%-35s %-25s %-25s %-25s",
				"Type(synchronized)", "Size", "Nanoseconds", "Seconds");
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

	public void runSequential2() {
		long startTime = System.nanoTime();
		Permutation perm = new Permutation();
		List<String> strList = perm.getPermutationWithCopyonWriteArrayList(str);
		List<String> numList = perm.getPermutationWithCopyonWriteArrayList(nos);
		long endTime = System.nanoTime();
		long diffTime = endTime - startTime;

		double C3 = 1L * 1000L * 1000L * 1000L;
		double timeInSec = diffTime / C3;
		String headerStr = String.format("%-35s %-25s %-25s %-25s",
				"Type(CopyonWriteArrayList)", "Size", "Nanoseconds", "Seconds");
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

	public void runSequential3() {
		long startTime = System.nanoTime();
		Permutation perm = new Permutation();
		List<String> strList = perm.getPermutationWithLock(str);
		List<String> numList = perm.getPermutationWithLock(nos);
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
		new Test1().runSequential();
		new Test1().runSequential1();
		new Test1().runSequential2();
		new Test1().runSequential3();
	}

}
