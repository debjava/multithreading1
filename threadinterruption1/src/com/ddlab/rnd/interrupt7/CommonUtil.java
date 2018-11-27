package com.ddlab.rnd.interrupt7;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CommonUtil {
	
	private Lock lock = new ReentrantLock();
	
//	public void execute() {
//		lock.lock();
//		System.out.printf("%-30s %-30s %n", "Thread Name","Counter");
//		try {
//			for( int i = 0 ; i < 10 ; i++ ){
//				System.out.printf("%-30s %-30s %n", Thread.currentThread().getName(),i);
//				Thread.sleep(10);
//			}
//		}
//		catch( InterruptedException ie){
//			ie.printStackTrace();
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//		finally{
//			lock.unlock();
//		}
//	}
	
	public synchronized void execute() {
			System.out.printf("%-30s %-30s %n", "Thread Name","Counter");
			if( Thread.currentThread().isInterrupted()) return;
			try {
				for( int i = 0 ; i < 10 ; i++ ){
					System.out.printf("%-30s %-30s %n", Thread.currentThread().getName(),i);
//					Thread.sleep(10);
					TimeUnit.SECONDS.sleep(1);
				}
			}
			catch( InterruptedException ie){
				ie.printStackTrace();
//				Thread.currentThread().interrupt();
//				return;
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

}
