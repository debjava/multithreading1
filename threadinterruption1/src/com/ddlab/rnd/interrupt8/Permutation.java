package com.ddlab.rnd.interrupt8;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Permutation {  

	//    public List<String> getPermutation(String input) {  
	//        List<String> collection = null;  
	//        if (input.length() == 1) {  
	//            collection = new ArrayList<String>();  
	//            collection.add(input);  
	//            return collection;  
	//        } else {  
	//            collection = getPermutation(input.substring(1));  
	//            Character first = input.charAt(0);  
	//            List<String> result = new ArrayList<String>();  
	//            for (String str : collection) {  
	//                for (int i = 0; i < str.length(); i++) {  
	//                    String item = str.substring(0, i) + first  
	//                            + str.substring(i);  
	////                    System.out.println(item);
	//                    System.out.println(Thread.currentThread().getName()+"<---->"+item);
	////                    System.out.println();
	//                    result.add(item);  
	//                }  
	//                String item = str.concat(first.toString());  
	//                result.add(item);  
	//            }  
	//            return result;  
	//        }  
	//    }

//	public synchronized List<String> getPermutation(String input) {  
//		List<String> collection = null;  
//		if (input.length() == 1) {  
//			collection = new ArrayList<String>();  
//			collection.add(input);  
//			return collection;  
//		} else {  
//			collection = getPermutation(input.substring(1));  
//			Character first = input.charAt(0);  
//			List<String> result = new ArrayList<String>();  
//			for (String str : collection) {  
//				for (int i = 0; i < str.length(); i++) {  
//					String item = str.substring(0, i) + first  
//					+ str.substring(i);  
//					//              System.out.println(item);
//					System.out.println(Thread.currentThread().getName()+"<---->"+item);
//					//              System.out.println();
//					result.add(item);  
//				}  
//				String item = str.concat(first.toString());  
//				result.add(item);  
//			}  
//			return result;  
//		}  
//	}


		public List<String> getPermutation(String input) {  
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
	                    System.out.println(item);
	//                    System.out.println(Thread.currentThread().getName()+"<---->"+item);
	//                    System.out.println();
	                    result.add(item);  
	                }  
	                String item = str.concat(first.toString());  
	                result.add(item);  
	            }  
	            return result;  
	        }  
	    }  
}