package com.ddlab.rnd.interrupt6;
import java.io.File;

public class SvnThread1 extends Thread 
{
	private String svnRootPath ;
	
	private FileUtil1 fileUtil;
	
	public SvnThread1( String svnRootPath )
	{
		this.svnRootPath = svnRootPath;
		super.setName("SVN Thread");
	}
	
	public SvnThread1( String svnRootPath , FileUtil1 fileUtil )
	{
		this.svnRootPath = svnRootPath;
		this.fileUtil = fileUtil;
		super.setName("SVN Thread");
	}
	
	@Override
	public void run() 
	{
//		new FileUtil().traverse( new File(svnRootPath));
		fileUtil.traverse( new File(svnRootPath));
		System.out.println("************* SVN Completed *******************");
	}
	
//	@Override
//	public void interrupt() 
//	{
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ You can not interrupt @@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ You can not interrupt @@@@@@@@@@@@@@@@@@@@@@@@@@@");
//		System.out.println("@@@@@@@@@@@@@@@@@@@@@@ You can not interrupt @@@@@@@@@@@@@@@@@@@@@@@@@@@");
//	}
}
