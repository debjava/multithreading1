package com.ddlab.rnd.thread5;

public class Thread2 implements Runnable 
{
	private Common cmn;
	public Thread2()
	{
		
	}
	
	public Thread2( Common cmn )
	{
		this.cmn = cmn;
	}
	
	@Override
	public void run() 
	{
//		new Common().doTask2();
		cmn.doTask2();
	}

}
