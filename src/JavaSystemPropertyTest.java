
import java.util.Map;

public class JavaSystemPropertyTest
{
	
	public static void main(String[] args)
	{
		//testArg1 passed as VM argument in eclipse, or from command line
		System.out.println("All properties:\n");
		for(Map.Entry<Object, Object> propEntry: System.getProperties().entrySet())
		{
			System.out.println(propEntry.getKey()+" = "+propEntry.getValue());
		}
	}

}
