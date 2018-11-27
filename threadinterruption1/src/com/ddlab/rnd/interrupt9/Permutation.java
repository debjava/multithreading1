package com.ddlab.rnd.interrupt9;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**This class provides various methods to get the list of Strings after permutations.
 * @author <a href="mailto:debadatta.mishra@gmail.com">Debadatta Mishra(PIKU)</a>
 *
 */
public class Permutation {
	private Lock lock = new ReentrantLock();
	/**
	 * Method for normal permutation with 
	 * <li>no <code>synchronized</code> keyword</li> 
	 * <li>no {@link CopyOnWriteArrayList}</li>
	 * 
	 * @param input of type String
	 * @return a List of Strings
	 */
	public List<String> getPermutation(String input) {
		List<String> collection = null;
		if (input.length() == 1) {
			collection = new ArrayList<String>();
			collection.add(input);
			return collection;
		} else {
			collection = getPermutation(input.substring(1));
			Character first = input.charAt(0);
			List<String> result = new ArrayList<String>();
			for (String str : collection) {
				for (int i = 0; i < str.length(); i++) {
					String item = str.substring(0, i) + first
							+ str.substring(i);
					result.add(item);
				}
				String item = str.concat(first.toString());
				result.add(item);
			}
			return result;
		}
	}

	/**
	 * Method for normal permutation with 
	 * <li><code>synchronized</code> keyword</li>  
	 * <li>no {@link CopyOnWriteArrayList} </li> 
	 * 
	 * @param input of type String
	 * @return a List of Strings
	 */
	public synchronized List<String> getPermutationWithSynch(String input) {
		List<String> collection = null;
		if (input.length() == 1) {
			collection = new ArrayList<String>();
			collection.add(input);
			return collection;
		} else {
			collection = getPermutation(input.substring(1));
			Character first = input.charAt(0);
			List<String> result = new ArrayList<String>();
			for (String str : collection) {
				for (int i = 0; i < str.length(); i++) {
					String item = str.substring(0, i) + first
							+ str.substring(i);
					result.add(item);
				}
				String item = str.concat(first.toString());
				result.add(item);
			}
			return result;
		}
	}

	/**
	 * Method for normal permutation with 
	 * <li>no <code>synchronized</code> keyword </li> 
	 * <li>{@link CopyOnWriteArrayList} </li> 
	 * @param input of type String
	 * @return a List of Strings
	 */
	public List<String> getPermutationWithCopyonWriteArrayList(String input) {
		List<String> collection = null;
		if (input.length() == 1) {
			collection = new CopyOnWriteArrayList<String>();
			collection.add(input);
			return collection;
		} else {
			collection = getPermutation(input.substring(1));
			Character first = input.charAt(0);
			List<String> result = new CopyOnWriteArrayList<String>();
			for (String str : collection) {
				for (int i = 0; i < str.length(); i++) {
					String item = str.substring(0, i) + first
							+ str.substring(i);
					result.add(item);
				}
				String item = str.concat(first.toString());
				result.add(item);
			}
			return result;
		}
	}
	
	/**
	 * Method for normal permutation with 
	 * <li>no <code>synchronized</code> keyword </li> 
	 * <li>no {@link CopyOnWriteArrayList} </li> 
	 * <li>{@link Lock} </li> 
	 * @param input of type String
	 * @return a List of Strings
	 */
	public List<String> getPermutationWithLock(String input) {
		List<String> permList = null;
		try 
		{
			lock.lock();
			permList = getPermutationWithCopyonWriteArrayList(input);
		}
		catch (Exception e) 
		{
			System.err.print("Unexpected exception ....");
			e.printStackTrace();
		}
		finally
		{
			lock.unlock();
		}
		return permList;
	}

}