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
////		super.interrupt();
//		super.run();
//	}
}
