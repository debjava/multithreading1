package com.ddlab.rnd.thread8;

public class Test1 {

	public static void main(String[] args) {
		
		Thread th1 = new Thread( new Thread1() );
		Thread th2 = new Thread( new Thread2());
		
		th2.start();
		th1.start();
		
		boolean flag = true;
		while( flag )
		{
			if( Thread1.th1Counter == 7 )
			{
				th1.interrupt();
				flag = false;
			}
		}
	}

}
