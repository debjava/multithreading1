package com.ddlab.rnd.interrupt1;
import com.ddlab.rnd.interrupt2.Thread2;

public class TestThread1 {
	public static void main(String[] args) {
		Thread th2 = new Thread2();
		th2.setName("Thread-2");
		th2.start();
	}

}
