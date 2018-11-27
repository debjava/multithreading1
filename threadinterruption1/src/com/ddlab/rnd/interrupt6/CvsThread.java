package com.ddlab.rnd.interrupt6;
import java.io.File;

public class CvsThread extends Thread 
{
	private String cvsRootPath ;
	private FileUtil1 fileUtil;
	
	public CvsThread( String cvsRootPath )
	{
		this.cvsRootPath = cvsRootPath;
		super.setName("CVS Thread");
	}
	
	public CvsThread( String cvsRootPath , FileUtil1 fileUtil)
	{
		this.cvsRootPath = cvsRootPath;
		this.fileUtil = fileUtil;
		super.setName("CVS Thread");
	}
	
	@Override
	public void run() 
	{
		fileUtil.traverse( new File(cvsRootPath));
		System.out.println("************* CVS Completed *******************");
	}
	
//	@Override
//	public void interrupt() 
//	{
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ You can not interrupt @@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ You can not interrupt @@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ You can not interrupt @@@@@@@@@@@@@@@@@@@@@@@@@@@");
////		super.interrupt();
//		super.run();
//	}
	
}
