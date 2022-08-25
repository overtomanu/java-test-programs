
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class MapDataTest {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Map> listOfMaps = new ArrayList<Map>();
		Map map1 = new HashMap<Object,Object>(), map2 = new HashMap<Object,Object>() ,map3 = new HashMap<Object,Object>();
		map1.put("test", "value");
		map2.put("test", "value");
		map3.put("test", "value");
		map1.put("test1", "value1");
		map2.put("test1", "value2");
		map3.put("test1", "value2");
		listOfMaps.add(map1);
		listOfMaps.add(map2);
		listOfMaps.add(map3);
		
		int count=0;
		for(Map map:listOfMaps)
		{
			count++;
			System.out.println("Map "+count+"| Key:test result:"+DataManager.isDiffFromPrev("test",map,false));
			System.out.println("Map "+count+"| Key:test1 result:"+DataManager.isDiffFromPrev("test1",map,true));
		}
	}

}

@SuppressWarnings("rawtypes")
class DataManager
{
	private static Map prevData = null;
	public static boolean isDiffFromPrev(Object key, Map data,boolean assignPrevData)
	{
		boolean result;
		 if(prevData==null)
		 {
			result=true;
		 }
		 else
		 {
			 Object value,prevValue;
			 
			if(data.containsKey(key) && (value=data.get(key))!=null && 
					prevData.containsKey(key) && (prevValue=prevData.get(key))!=null)
			{
				result=!(value.equals(prevValue));
			}
			else
			{
				result=true;
			}
		 }
		 if(assignPrevData)
		 {
			 prevData=data;
		 }
		 return result;
	}
}