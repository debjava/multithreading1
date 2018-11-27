package com.ddlab.rnd.interrupt5;
import java.io.File;

public class CvsThread extends Thread 
{
	private String cvsRootPath ;
	private FileUtil fileUtil;
	
	public CvsThread( String cvsRootPath )
	{
		this.cvsRootPath = cvsRootPath;
		super.setName("CVS Thread");
	}
	
	public CvsThread( String cvsRootPath , FileUtil fileUtil)
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
	
}
