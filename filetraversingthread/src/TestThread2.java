import java.util.concurrent.TimeUnit;


public class TestThread2 {

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		String svnRootPath = "F:/tempdelete/cvs";
		FileUtil1 util = new FileUtil1();
		
		long startTime = System.nanoTime();
		SvnThread1 svnT = new SvnThread1(svnRootPath,util);
//		svnT.setDaemon(true);
		svnT.start();
		boolean flag = true;
		while( flag )
		{
			if( !svnT.isAlive() )
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
