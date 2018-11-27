package com.ddlab.rnd.interrupt8;

import java.util.Collections;
import java.util.List;

public class StringThread extends Thread {
	private Permutation perm;
	private String input;
	private List<String> permList;
	
	public StringThread(Permutation perm,String input,List<String> permList){
		this.perm = perm;
		this.input = input;
		this.permList = permList;
	}
	
	public StringThread(String input,List<String> permList){
		this.input = input;
		this.permList = permList;
	}
	
	@Override
	public void run() {
//		this.permList = perm.getPermutation(input);
//		Collections.copy(permList, perm.getPermutation(input));
//		permList.addAll(perm.getPermutation(input));
		permList.addAll(new Permutation().getPermutation(input));
		System.out.println("String permutations completed..."+permList.size());
	}
	
}
