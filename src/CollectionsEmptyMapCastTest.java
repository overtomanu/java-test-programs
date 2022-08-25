

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CollectionsEmptyMapCastTest
{
	public static void main(String[] args)
	{
		HashMap newEmptyMap = new HashMap();
		System.out.println((Map<Integer,String>)Collections.<Integer,String>emptyMap());
		System.out.println((Map<Integer,String>)newEmptyMap);
	}
}
