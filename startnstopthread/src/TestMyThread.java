import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class TestMyThread 
{
	public static void main(String[] args) 
	{
		Thread th = null;
		try 
		{
			th = new MyThread();
			th.start();
			for( int i = 0 ; i < 10 ; i++ )
			{
				System.out.println("Current Value--->"+i);
				TimeUnit.SECONDS.sleep(2);
				if( i == 7 )
				{
					th.interrupt();
					System.out.println("************ Thread Interrupted ***********");
					System.out.println("Again start the thread......");
					System.out.println("Th value :::"+th);
					th = new MyThread();
					th.start();
				}
			}
			boolean flag = true;
			while( flag )
			{
//				if( th.isAlive())
//				{
//					Map<Thread,StackTraceElement[]> thMap = Thread.getAllStackTraces();
//					for( Iterator<Map.Entry<Thread, StackTraceElement[]>> itr = thMap.entrySet().iterator() ; itr.hasNext() ;)
//					{
//						Map.Entry<Thread, StackTraceElement[]> me = itr.next();
//						Thread th11 =me.getKey();
//						
//						System.out.println("Thread Name :::"+th11.getName());
//					}
//				}
				if( !th.isAlive()) flag = false;
			}
			System.out.println("******** Task Completed **********");
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

}
