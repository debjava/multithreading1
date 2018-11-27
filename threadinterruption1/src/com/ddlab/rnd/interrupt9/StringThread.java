package com.ddlab.rnd.interrupt9;

import java.util.List;

public class StringThread extends Thread {
//	private Permutation perm;
	private String input;
	private List<String> permList;
	
//	public StringThread(Permutation perm,String input,List<String> permList){
//		this.perm = perm;
//		this.input = input;
//		this.permList = permList;
//	}
	
	public StringThread(String input,List<String> permList){
		this.input = input;
		this.permList = permList;
	}
	
	@Override
	public void run() {
//		permList.addAll(new Permutation().getPermutation(input));
//		permList.addAll(new Permutation().getPermutationWithSynch(input));
//		permList.addAll(new Permutation().getPermutationWithCopyonWriteArrayList(input));
		permList.addAll(new Permutation().getPermutationWithLock(input));
	}
	
}
