package com.ddlab.rnd.interrupt5;
import java.util.concurrent.TimeUnit;

public class Test1 {

	public static void main(String[] args) throws Exception
	{
		String svnRootPath = "F:/tempdelete/cvs";
		String cvsRootPath = "F:/tempdelete/svn";
		FileUtil util = new FileUtil();
		
		long startTime = System.nanoTime();
		SvnThread svnT = new SvnThread(svnRootPath,util);
		CvsThread cvsT = new CvsThread(cvsRootPath,util);
		cvsT.start();
		svnT.start();
		boolean flag = true;
		while( flag )
		{
			if( !svnT.isAlive() && !cvsT.isAlive() )
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
