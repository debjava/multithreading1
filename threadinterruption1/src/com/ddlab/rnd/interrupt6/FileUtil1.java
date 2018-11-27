package com.ddlab.rnd.interrupt6;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileUtil1 
{
	public synchronized void traverse( File rootFile )
	{
		try 
		{
			File[] files = rootFile.listFiles();
			for( File file : files )
			{
				if( Thread.currentThread().isInterrupted() )
				{
					System.out.println("Yes, thread has been interrupted, so we should handle in our manner now....");
					if( Thread.currentThread().isAlive() )
					{
//						System.out.println("It is still alive...");
						Thread.currentThread().interrupt();
						break; //It will work
//						return;//This will work 
					}
					break;
				}
				else if( file.isDirectory() ) traverse(file);
				else
				{
					System.out.println("FilePath"+"<---->"+file.getAbsolutePath());
					System.out.println("Current Thread Name :::"+Thread.currentThread().getName());
					if( file.getName().equals("Xusage.txt"))
					{
						System.out.println("******************************************************************");
						System.out.println("Got the file...");
						System.out.println("******************************************************************");
						Thread.currentThread().interrupt();
						System.out.println("Now Interrupted..........");
//						TimeUnit.SECONDS.sleep(1); //Never use this statement in case of thread interruption
						break;
					}
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return;
		}
	}
}
