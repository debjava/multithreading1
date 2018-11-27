package com.ddlab.rnd.interrupt8;

import java.util.Collections;
import java.util.List;

public class NumberThread extends Thread {
	private Permutation perm;
	private String input;
	private List<String> permList;
	
	public NumberThread(Permutation perm,String input,List<String> permList){
		this.perm = perm;
		this.input = input;
		this.permList = permList;
	}
	
	public NumberThread(String input,List<String> permList){
		this.input = input;
		this.permList = permList;
	}
	
	@Override
	public void run() {
//		permList = perm.getPermutation(input);
//		Collections.copy(permList, perm.getPermutation(input));
//		permList.addAll(perm.getPermutation(input));
		permList.addAll(new Permutation().getPermutation(input));
	}
	
}
