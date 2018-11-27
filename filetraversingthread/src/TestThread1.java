

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestThread1
{
	//Sequential Approach
//	public static void main(String[] args)
//	{
//		String svnRootPath = "F:/tempdelete/cvs";
//		String cvsRootPath = "F:/tempdelete/svn";
//		FileUtil util = new FileUtil();
//		long startTime = System.nanoTime();
//		
//		util.traverse( new File(svnRootPath));
////		traverse( new File(cvsRootPath));
//		
//		long endTime = System.nanoTime();
//		
//		long timeDifference = endTime - startTime;
//		System.out.println("Total Time Difference :::"+timeDifference+" nano seconds");
//		long seconds = TimeUnit.NANOSECONDS.toSeconds(timeDifference);
//		System.out.println("Total Time Difference :::"+seconds+" seconds");
//	}
	
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
	
//	public static void main(String[] args) throws Exception
//	{
//		String svnRootPath = "F:/tempdelete/cvs";
//		String cvsRootPath = "F:/tempdelete/svn";
//		FileUtil util = new FileUtil();
//		
//		long startTime = System.nanoTime();
//		SvnThread svnT = new SvnThread(svnRootPath,util);
//		CvsThread cvsT = new CvsThread(cvsRootPath,util);
//		
//		ExecutorService exService = Executors.newFixedThreadPool(2);
//		exService.execute(svnT);
//		exService.execute(cvsT);
//		exService.shutdown();
//		
//		while( !exService.isTerminated() ){}
//		
//		long endTime = System.nanoTime();
//		long timeDifference = endTime - startTime;
//		System.out.println("Total Time Difference :::"+timeDifference+" nano seconds");
//		long seconds = TimeUnit.NANOSECONDS.toSeconds(timeDifference);
//		System.out.println("Total Time Difference :::"+seconds+" seconds");
//	}

}
