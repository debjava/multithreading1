package com.iit.rnd.web.thread.server;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebPageServlet extends HttpServlet
{
	private static final long serialVersionUID = 7127228992524229255L;
	private Thread th = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		System.out.println("doPost Method of WebPageServlet ...");
		StringBuilder builder = new StringBuilder();
		StringBuilder threadStatus = new StringBuilder();
		try 
		{
			String status = request.getParameter("name");
			System.out.println("Status :::"+status);
			if( status.equalsIgnoreCase("start"))
			{
				startThread(threadStatus,builder);
				System.out.println("Thread started successfully ...");
				builder.append("Thread started successfully ...");
			}
			else
			{
				stopThread(threadStatus, builder);
			}
			
		}
		catch (Exception e) 
		{
			builder.append("\n---------- Exception Details -----------\n");
			builder.append(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("-------->"+builder.toString());

		PrintWriter out = response.getWriter();
		out.println(threadStatus.toString()+"\n"+builder.toString());
	}
	
	private void startThread( StringBuilder threadStatus , StringBuilder builder)
	{
		System.out.println("startThread method called .....");
		try 
		{
			if( th == null )
			{
//				th = new SepaThread(threadStatus);
				th = new PaymentThread(threadStatus);
				th.start();
			}
			else if( th.isAlive() )
			{
				System.out.println("Current Thread is running ...");
				builder.append("Current Thread is running ...");
			}
			else
			{
				System.out.println("Thread is dead now ...");
				builder.append("Thread is dead now ...");
//				th = new SepaThread(threadStatus);
				th = new PaymentThread(threadStatus);
				th.start();
			}
		}
		catch( IllegalMonitorStateException ime )
		{
			ime.printStackTrace();
			builder.append("Thread instance is not null, but it is not running...");
			builder.append("Start the thread ...");
			th = new SepaThread(builder);
			th.start();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			builder.append("\nUnKnown Exception while starting the thread ...");
		}
	}
	
	private void stopThread( StringBuilder threadStatus , StringBuilder builder)
	{
		System.out.println("StopThread method called .....");
		
		try 
		{
			if( th.isAlive() )
			{
				System.out.println("Current Thread is running , now time to interrupt the thread ...");
				builder.append("Current Thread is running , now time to interrupt the thread ...");
				th.interrupt();
			}
			else
			{
				System.out.println("Thread is dead now ...");
				builder.append("Thread is dead now ..., should be started...");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			builder.append("\nUnKnown Exception while stopping the thread ...");
		}
		builder.append("Thread stopped successfully .....");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		System.out.println("doGet Method of WebPageServlet ...");
		doPost(request, response);
	}

}
