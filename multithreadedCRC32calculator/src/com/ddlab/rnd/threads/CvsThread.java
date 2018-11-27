package com.ddlab.rnd.threads;

import java.io.File;

public class CvsThread extends Thread 
{
	private String cvsRootPath ;
	
	public CvsThread( String cvsRootPath )
	{
		this.cvsRootPath = cvsRootPath;
		super.setName("CVS Thread");
	}
	
	@Override
	public void run() 
	{
		traverse( new File(cvsRootPath));
		System.out.println("************* CVS Completed *******************");
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
