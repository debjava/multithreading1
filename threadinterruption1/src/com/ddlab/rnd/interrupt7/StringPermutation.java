package com.ddlab.rnd.interrupt7;
import java.util.ArrayList;  
import java.util.List;  
import java.util.concurrent.TimeUnit;
  
public class StringPermutation {  
  
    public static List<String> getPermutation(String input) {  
  
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
                    System.out.println(item);
                    result.add(item);  
                }  
                String item = str.concat(first.toString());  
                result.add(item);  
            }  
            return result;  
        }  
  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
    	long startTime = System.nanoTime();
        System.out.println(StringPermutation.getPermutation("abcdefghi"));  
        long endTime = System.nanoTime();
		long diffTime = endTime - startTime;
		System.out.println("Diff in Nanosec :::"+diffTime);
		System.out.println("Diff in Sec :::"+TimeUnit.NANOSECONDS.toSeconds(diffTime));
//		System.out.printf("%-30s %-30s %-30s %-30s %-30s %n","Result ","Nanoseconds","Microsecond","Millisecond","Seconds");
//		System.out.printf("%-30s %-30s %-30s %-30s %-30s", "Result ", diffTime,
//				TimeUnit.NANOSECONDS.toMicros(diffTime),
//				TimeUnit.NANOSECONDS.toMillis(diffTime),
//				TimeUnit.NANOSECONDS.toSeconds(diffTime));
  
    }  
}