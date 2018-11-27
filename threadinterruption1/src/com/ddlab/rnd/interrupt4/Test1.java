package com.ddlab.rnd.interrupt4;

public class Test1 {

	public static void main(String[] args) {
		MyUtil util = new MyUtil();
		Thread th3 = new Thread( new Thread3(util));
		th3.setName("Thread-1");
		Thread th4 = new Thread( new Thread4(util));
		th3.setName("Thread-2");
		th3.start();
		th4.start();
	}

}
