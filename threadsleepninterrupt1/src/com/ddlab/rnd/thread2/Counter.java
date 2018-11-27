package com.ddlab.rnd.thread2;

public class Counter 
{
	private int c = 0;
//	private long c = 0L;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized int value() {
        return c;
    }
    
//    public long value() {
//        return c;
//    }

}
