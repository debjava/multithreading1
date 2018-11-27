package com.ddlab.rnd.interrupt9;

import java.util.List;

public class NumberThread extends Thread {
//	private Permutation perm;
	private String input;
	private List<String> permList;
	
//	public NumberThread(Permutation perm,String input,List<String> permList){
//		this.perm = perm;
//		this.input = input;
//		this.permList = permList;
//	}
	
	public NumberThread(String input,List<String> permList){
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
