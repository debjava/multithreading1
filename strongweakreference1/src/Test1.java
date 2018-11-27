import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;


public class Test1 {

	WeakHashMap map=new WeakHashMap();
	String t= new String("1");
	
	public void doIt() throws Exception
	{
		map.put(t,"orange");
		t=null;
		TimeUnit.SECONDS.sleep(5);
		System.out.println("The Map"+map);
//		System.runFinalizersOnExit(true);
		System.out.println("The Map"+map);
		System.out.println("The Map"+map);
		System.out.println("The Map"+map);
		System.out.println("The Map"+map);
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Garbage collector ran successfully ...");
		super.finalize();
		System.out.println("Objects have been claimed ...");
		System.out.println("The Map inside finalize method :::"+map);
	}
	public static void main(String[] args) throws Exception
	{
//		Organisation org = new Organisation();
//		org.populateEmps();
//		Map<String, String> empMap = org.getEmpMap();
//		for( int i = 0 ; i < 10 ; i++ )
//		{
//			System.out.println("Employees :::"+empMap);
//			TimeUnit.SECONDS.sleep(5);
//		}
//		System.out.println("After Garbage Collection :::"+empMap);
//		System.gc();
//		System.runFinalizersOnExit(true);
//		System.out.println("After Garbage Collection :::"+empMap);
//		System.out.println("After Garbage Collection :::"+empMap);
//		System.out.println("After Garbage Collection :::"+empMap);
//		System.out.println("After Garbage Collection :::"+empMap);
		
		
		WeakHashMap map=new WeakHashMap();
		String t= new String("1");
		map.put(t,"orange");
		t=null;
		TimeUnit.SECONDS.sleep(5);
		System.gc();
//		System.runFinalizersOnExit(true);
		System.out.println("The Map"+map);
		
//		new Test1().doIt();
////		System.runFinalizersOnExit(true);
//		System.out.println("Completed ............");
		
		
		
		
	}

}
