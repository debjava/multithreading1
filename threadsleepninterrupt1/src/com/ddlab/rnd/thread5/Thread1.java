package com.ddlab.rnd.thread5;

public class Thread1 implements Runnable 
{
	private Common cmn;
	public Thread1()
	{
		
	}
	
	public Thread1( Common cmn )
	{
		this.cmn = cmn;
	}
	@Override
	public void run() 
	{
//		new Common().doTask1();
		cmn.doTask1();
	}

}
