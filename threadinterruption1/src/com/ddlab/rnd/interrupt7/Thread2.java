package com.ddlab.rnd.interrupt7;

import java.util.concurrent.TimeUnit;

public class Thread2 extends Thread 
{
	private CommonUtil util ;
	
	public Thread2(CommonUtil util){
		this.util = util;
	}
	
	public Thread2(){

	}

	@Override
	public void run() {
		util.execute();
	}

}
