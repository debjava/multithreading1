package com.ddlab.rnd.interrupt6;
import java.util.concurrent.TimeUnit;

public class TestCvsSvn {

	public static void main(String[] args)
	{
		String svnRootPath = "F:/tempdelete/svn";
		String cvsRootPath = "F:/tempdelete/cvs";
		FileUtil1 util = new FileUtil1();
		
		long startTime = System.nanoTime();
//		SvnThread1 svnT = new SvnThread1(svnRootPath,util);
		CvsThread cvsT = new CvsThread(cvsRootPath,util);
		cvsT.start();
//		svnT.start();
		boolean flag = true;
		while( flag )
		{
			if( !cvsT.isAlive() )
			{
				System.out.println("All threads are dead....");
				flag = false;
			}
		}
		long endTime = System.nanoTime();
		long timeDifference = endTime - startTime;
		System.out.println("Total Time Difference :::"+timeDifference+" nano seconds");
		long seconds = TimeUnit.NANOSECONDS.toSeconds(timeDifference);
		System.out.println("Total Time Difference :::"+seconds+" seconds");

	}

}
