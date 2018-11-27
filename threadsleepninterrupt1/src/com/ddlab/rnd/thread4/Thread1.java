package com.ddlab.rnd.thread4;
public class Thread1 implements Runnable
{
	private CommonUtil2 util = null;
	public Thread1( CommonUtil2 util )
	{
		this.util = util;
	}
	
	public Thread1()
	{
		
	}
	
	@Override
	public void run() 
	{
//		CommonUtil2.doTask3();
//		System.out.println("In Thread-1---Value--->"+new CommonUtil2().getValue());
		try {
			new CommonUtil2().doTask4();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
