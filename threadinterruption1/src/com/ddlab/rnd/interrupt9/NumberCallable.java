package com.ddlab.rnd.interrupt9;

import java.util.List;
import java.util.concurrent.Callable;

public class NumberCallable implements Callable<List<String>>{
	private String input;
	
	public NumberCallable(String input){
		this.input = input;
	}
	
	@Override
	public List<String> call() throws Exception {
		return new Permutation().getPermutationWithLock(input);
	}

}
