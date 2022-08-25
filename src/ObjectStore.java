
import java.util.HashMap;
import java.util.Map;

public class ObjectStore
{
	private static Map<String,Object> objectMap = new HashMap<String,Object>();
	
	public static void storeObject(String objName,Object obj)
	{
		objectMap.put(objName, obj);
	}
	
	public static Object getObject(String objName)
	{
		return objectMap.get(objName);
	}
}
