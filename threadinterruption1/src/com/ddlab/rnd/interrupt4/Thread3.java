package com.ddlab.rnd.interrupt4;

public class Thread3 implements Runnable
{
	private MyUtil util;
	public Thread3( MyUtil util )
	{
		this.util = util;
	}
	@Override
	public void run() {
		util.execute();
	}
}
