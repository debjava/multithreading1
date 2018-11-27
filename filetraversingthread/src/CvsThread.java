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
//		new FileUtil().traverse( new File(cvsRootPath));
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
