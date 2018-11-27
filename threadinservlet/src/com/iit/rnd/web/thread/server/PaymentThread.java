package com.iit.rnd.web.thread.server;

public class PaymentThread extends Thread 
{
	private StringBuilder threadStatus = null;

	public PaymentThread( StringBuilder threadStatus )
	{
		this.threadStatus = threadStatus;
		setName("PaymentThread");
	}
	@Override
	public void run() 
	{
		System.out.println("Main Thread PaymentThread started ....");
		try 
		{
			Thread sepaThread = new SepaThread(threadStatus);
			Thread swiftThread = new SwiftThread(threadStatus);
			Thread target2Thread2 = new Target2Thread(threadStatus);
			
			sepaThread.start();
			swiftThread.start();
			target2Thread2.start();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
