package com.ddlab.rnd.interrupt5;
import java.io.File;

public class SvnThread extends Thread 
{
	private String svnRootPath ;
	
	private FileUtil fileUtil;
	
	public SvnThread( String svnRootPath )
	{
		this.svnRootPath = svnRootPath;
		super.setName("SVN Thread");
	}
	
	public SvnThread( String svnRootPath , FileUtil fileUtil )
	{
		this.svnRootPath = svnRootPath;
		this.fileUtil = fileUtil;
		super.setName("SVN Thread");
	}
	
	@Override
	public void run() 
	{
		fileUtil.traverse( new File(svnRootPath));
		System.out.println("************* SVN Completed *******************");
	}
	
}
