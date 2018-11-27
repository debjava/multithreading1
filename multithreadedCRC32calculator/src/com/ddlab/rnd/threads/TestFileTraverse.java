package com.ddlab.rnd.threads;
import java.io.File;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



public class TestFileTraverse 
{
	private static CountDownLatch latch;

	//	private static int filesCounter = 0;
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
//				System.out.println(file.getAbsolutePath()+"<---->"+FileUtil.getChecksum(file));
//				System.out.println("Current Thread Name :::"+Thread.currentThread().getName());
			}
		}
	}

	//	public static void main(String[] args) 
	//	{
	//		String svnRootPath = "C:/SVN/OPEsrc";
	//		String cvsRootPath = "C:/CVS1/OPEsrc";
	//		long startTime = System.nanoTime();
	//		
	//		TestFileTraverse.traverse( new File(svnRootPath));
	//		TestFileTraverse.traverse( new File(cvsRootPath));
	////		System.out.println("Total Files---->"+filesCounter);
	//		
	//		long endTime = System.nanoTime();
	//		
	//		System.out.println("Total Time Taken :::"+(endTime-startTime)+" nano seconds");
	//	}

	private static class SimpleThread extends Thread 
	{
		public void run() 
		{
			String svnRootPath = "C:/SVN/OPEsrc";
			String cvsRootPath = "C:/CVS1/OPEsrc";
			SvnThread svnT = new SvnThread(svnRootPath);
			CvsThread cvsT = new CvsThread(cvsRootPath);
			svnT.start();
			cvsT.start();
			latch.countDown();
		}
	}

	private static void startThreads()
	{
		long startTime = System.nanoTime();
		String svnRootPath = "C:/SVN/OPEsrc";
		String cvsRootPath = "C:/CVS1/OPEsrc";
		SvnThread svnT = new SvnThread(svnRootPath);
		CvsThread cvsT = new CvsThread(cvsRootPath);
		svnT.start();
		cvsT.start();

		boolean svnFlag = svnT.isAlive();
		boolean cvsFlag = cvsT.isAlive();
		boolean check = cvsFlag & svnFlag ;
		long endTime = System.nanoTime();


		// Check if the thread has finished in a non-blocking way
		if (svnT.isAlive()) {
			// Thread has not finished
		} else {
			// Finished
		}

		// Wait for the thread to finish but don't wait longer than a
		// specified time
		long delayMillis = 5000; // 5 seconds
		try {
			svnT.join(delayMillis);

			if (svnT.isAlive()) {
				// Timeout occurred; thread has not finished
			} else {
				// Finished
			}
		} catch (InterruptedException e) {
			// Thread was interrupted
		}

		// Wait indefinitely for the thread to finish
		//		try {
		//			svnT.join();
		//			
		//			cvsT.join();
		//		    // Finished
		//			
		//			System.out.println("Total Time Taken :::"+(endTime-startTime)+" nano seconds");
		//			
		//			
		//		} catch (InterruptedException e) {
		//		    // Thread was interrupted
		//		}





		boolean thread1IsAlive = true;
		boolean thread2IsAlive = true;

		do {
			if (thread1IsAlive && !svnT.isAlive()) {
				thread1IsAlive = false;
				System.out.println("Thread 1 is dead.");
			}
			if (thread2IsAlive && !cvsT.isAlive()) {
				thread2IsAlive = false;
				System.out.println("Thread 2 is dead.");
			}
		} while(thread1IsAlive || thread2IsAlive);

	}

//	public static void main(String[] args) throws Exception
//	{
//		long startTime = System.nanoTime();
//		startThreads();
//		//		Thread.currentThread().join();
////		long endTime = System.nanoTime();
////		System.out.println("Total Time Taken :::"+(endTime-startTime)+" nano seconds");
//	}
	
	public static void main(String[] args) throws Exception
	{
		long startTime = System.nanoTime();
		final String svnRootPath = "C:/SVN/OPEsrc";
		final String cvsRootPath = "C:/CVS1/OPEsrc";
		ExecutorService es = Executors.newCachedThreadPool();
		es.execute(new Runnable() 
		{
			@Override
			public void run() 
			{
				TestFileTraverse.traverse( new File(svnRootPath));
				System.out.println("************* SVN Completed *******************"); 
			}
			
		});
		
		es.execute(new Runnable() 
		{
			@Override
			public void run() 
			{
				TestFileTraverse.traverse( new File(cvsRootPath));
				System.out.println("************* CVS Completed *******************"); 
			}
			
		});
		
		es.shutdown();
		System.out.println("***************** END ***************");
		long endTime = System.nanoTime();
		boolean finshed = es.awaitTermination(1, TimeUnit.MINUTES);
	System.out.println("Total Time Taken :::"+(endTime-startTime)+" nano seconds");
	
//		
	}
	
	
	

}
