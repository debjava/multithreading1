package com.ddlab.rnd.threads;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class TestThread1
{
	public static void traverse( File rootFile )
	{
		File[] files = rootFile.listFiles();
		for( File file : files )
		{
			if( file.isDirectory() ) traverse(file);
			else
			{
				//				System.out.println("Path--->"+file.getAbsolutePath());
				//				filesCounter++;
				System.out.println(file.getAbsolutePath()+"<---->"+FileUtil.getChecksum(file));
//				System.out.println("Current Thread Name :::"+Thread.currentThread().getName());
			}
		}
	}
	//Sequential Approach
	public static void main1(String[] args)
	{
		String svnRootPath = "F:/tempdelete/cvs";
		String cvsRootPath = "F:/tempdelete/svn";
		
		long startTime = System.nanoTime();
		
		traverse( new File(svnRootPath));
		traverse( new File(cvsRootPath));
		
		long endTime = System.nanoTime();
		
		long timeDifference = endTime - startTime;
		System.out.println("Total Time Difference :::"+timeDifference+" nano seconds");
		long seconds = TimeUnit.NANOSECONDS.toSeconds(timeDifference);
		System.out.println("Total Time Difference :::"+seconds+" seconds");
	}
	
	public static void main(String[] args) throws Exception
	{
		String svnRootPath = "F:/tempdelete/cvs";
		String cvsRootPath = "F:/tempdelete/svn";
		long startTime = System.nanoTime();
		SvnThread svnT = new SvnThread(svnRootPath);
		CvsThread cvsT = new CvsThread(cvsRootPath);
		svnT.start();
		svnT.join();
		cvsT.start();
		cvsT.join();
		long endTime = System.nanoTime();
		long timeDifference = endTime - startTime;
		System.out.println("Total Time Difference :::"+timeDifference+" nano seconds");
		long seconds = TimeUnit.NANOSECONDS.toSeconds(timeDifference);
		System.out.println("Total Time Difference :::"+seconds+" seconds");
	}

}
