package com.iit.rnd.web.thread.server;

import java.util.concurrent.TimeUnit;

public class SwiftThread extends Thread 
{
	private StringBuilder threadStatus = null;

	public SwiftThread( StringBuilder threadStatus )
	{
		this.threadStatus = threadStatus;
		setName("SwiftThread");
	}
	@Override
	public void run() 
	{
		boolean flag = true;
		int counter = 0;
		while( flag )
		{
			try 
			{
				counter++;
				if(Thread.currentThread().isInterrupted())
				{
					flag = false;
					Thread.currentThread().interrupt();
					threadStatus.append("Thread SwiftThread has been interrupted, stopped all operations");
					break;
				}
				else
				{
					System.out.println("Counter value in SwiftThread :::"+counter);
					TimeUnit.SECONDS.sleep(2);
				}
			}
			catch( InterruptedException ie )
			{
				ie.printStackTrace();
				threadStatus.append("InterruptedException exception in SwiftThread...\n").append(ie.getMessage());
				break;
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				threadStatus.append("Unknown exception in SwiftThread...\n").append(e.getMessage());
			}
		}

	}
}
