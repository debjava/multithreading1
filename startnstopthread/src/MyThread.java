import java.util.concurrent.TimeUnit;


public class MyThread extends Thread 
{
	public MyThread()
	{
		setName("MyThread");
	}
	@Override
	public void run() 
	{
		try 
		{
			for( int i = 0 ; i < 100 ; i++ )
			{
				System.out.println("I--->"+i);
				TimeUnit.SECONDS.sleep(2);
				if( isInterrupted() )
				{
					System.out.println("@@@@@@@@@@@ Thread Interrupted @@@@@@@@@@");
					break;
				}
			}
		}
		catch( InterruptedException ie )
		{
			Thread.currentThread().interrupt();
			return;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
