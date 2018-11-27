package com.ddlab.rnd.interrupt7;

import java.util.concurrent.TimeUnit;

public class Thread1 extends Thread 
{
	private CommonUtil util ;

	public Thread1(CommonUtil util){
		this.util = util;
	}

	public Thread1(){

	}

	@Override
	public void run() {
		util.execute();
	}

}
