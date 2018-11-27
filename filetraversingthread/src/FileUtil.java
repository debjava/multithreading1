import java.io.File;
import java.util.concurrent.TimeUnit;

public class FileUtil 
{
//	boolean gotFile = false;
	public synchronized void traverse( File rootFile )
	{
//		if( Thread.currentThread().isInterrupted() )
//		{
//			System.out.println("Muuuu Again it is coming here............");
//			if( Thread.currentThread().isInterrupted() ){ return;}
//			Thread.currentThread().interrupt();
////			TimeUnit.SECONDS.sleep(1);
//			return;
//		}
		try 
		{
			if( Thread.currentThread().isInterrupted() )
			{
				System.out.println("Again it is coming here............");
				return;
//				if( Thread.currentThread().isInterrupted() ){ return;}
//				Thread.currentThread().interrupt();
//				TimeUnit.SECONDS.sleep(1);
//				return;
			}
			File[] files = rootFile.listFiles();
			for( File file : files )
			{
//				if( gotFile ) break;
//				else if( file.isDirectory() ) traverse(file);
				if( Thread.currentThread().isInterrupted() )
				{
					System.out.println("111111111----Again it is coming here............");
					Thread.currentThread().interrupt();
//					TimeUnit.SECONDS.sleep(1);
//					return;
					break;
				}
				else if( file.isDirectory() ) traverse(file);
				else
				{
					System.out.println("FilePath"+"<---->"+file.getAbsolutePath());
					System.out.println("Current Thread Name :::"+Thread.currentThread().getName());
					if( file.getName().equals("Xusage.txt"))
					{
						System.out.println("******************************************************************");
						System.out.println("Got the file...");
						System.out.println("******************************************************************");
						Thread.currentThread().interrupt();
						System.out.println("Interrupted..........");
						
//						if( Thread.currentThread().isInterrupted() )
//						{
//							System.out.println("Again it is coming here............");
//							Thread.currentThread().interrupt();
//							return;
//						}
						
					}
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return;
		}
	}
}
