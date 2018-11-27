package com.ddlab.rnd.interrupt3;
public class TestMissileLaucnhingThread {
	public static void main(String[] args) {
		
//		Thread th1 = new MissileLaunchingThread();
//		th1.setName("Missile");
//		th1.start();
		
		Thread th1 = new Thread( new MissileLaunchingThread() );
		th1.setName("Missile");
		th1.start();
	}
}
