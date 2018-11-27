package com.ddlab.rnd.threads;

import java.io.File;

public class SvnThread extends Thread 
{
	private String svnRootPath ;
	
	public SvnThread( String svnRootPath )
	{
		this.svnRootPath = svnRootPath;
		super.setName("SVN Thread");
	}
	
	@Override
	public void run() 
	{
		traverse( new File(svnRootPath));
		System.out.println("************* SVN Completed *******************");
	}
	
	public void traverse( File rootFile )
	{
		File[] files = rootFile.listFiles();
		for( File file : files )
		{
			if( file.isDirectory() ) traverse(file);
			else
			{
				System.out.println(file.getAbsolutePath()+"<---->"+FileUtil.getChecksum(file));
				System.out.println("Current Thread Name :::"+Thread.currentThread().getName());
			}
		}
	}
}
