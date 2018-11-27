package com.ddlab.rnd.interrupt4;

public class Thread4 implements Runnable
{
	private MyUtil util;
	public Thread4( MyUtil util )
	{
		this.util = util;
	}
	@Override
	public void run() {
		util.execute();
	}
}
