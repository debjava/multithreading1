package com.iit.rnd.web.thread.server;

import java.util.concurrent.TimeUnit;

public class Target2Thread extends Thread 
{
	private StringBuilder threadStatus = null;

	public Target2Thread( StringBuilder threadStatus )
	{
		this.threadStatus = threadStatus;
		setName("Target2Thread");
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
					threadStatus.append("Thread Target2Thread has been interrupted, stopped all operations");
					break;
				}
				else
				{
					System.out.println("Counter value in Target2Thread :::"+counter);
					TimeUnit.SECONDS.sleep(2);
				}
			}
			catch( InterruptedException ie )
			{
				ie.printStackTrace();
				threadStatus.append("InterruptedException exception in Target2Thread...\n").append(ie.getMessage());
				break;
			}
			catch (Exception e) 
			{
				e.printStackTrace();
				threadStatus.append("Unknown exception in Target2Thread...\n").append(e.getMessage());
			}
		}

	}
}
