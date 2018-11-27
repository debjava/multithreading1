import java.util.Map;
import java.util.WeakHashMap;


public class Organisation {

	private Map<String,String> empMap = new WeakHashMap<String, String>();
	private String num1 = "1";
	private String num2 = "2";
	private String num3 = "3";
	
	public Map<String, String> getEmpMap() {
		return empMap;
	}
	public void populateEmps()
	{
		empMap.put(num1, "A");
		empMap.put(num2, "B");
		empMap.put(num3, "C");
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Garbage collector ran successfully ...");
		super.finalize();
		System.out.println("Objects have been claimed ...");
		
		String num1 = null;
		String num2 = null;
		String num3 = null;
		System.out.println("--->"+empMap);
	}
}
