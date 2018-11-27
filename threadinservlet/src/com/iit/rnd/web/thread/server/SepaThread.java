package com.iit.rnd.web.thread.server;

import java.util.concurrent.TimeUnit;

public class SepaThread extends Thread 
{
	private StringBuilder threadStatus = null;

	public SepaThread( StringBuilder threadStatus )
	{
		this.threadStatus = threadStatus;
		setName("SepaThread");
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
					threadStatus.append("Thread SepaThread has been interrupted, stopped all operations");
					break;
				}
				else
				{
					System.out.println("Counter value in SepaThread:::"+counter);
					TimeUnit.SECONDS.sleep(2);
				}
			}
			catch( InterruptedException ie )
			{
				ie.printStackTrace();
				threadStatus.append("InterruptedException exception in SepaThread...\n").append(ie.getMessage());
				break;
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				threadStatus.append("Unknown exception in SepaThread...\n").append(e.getMessage());
			}
		}

	}
}
