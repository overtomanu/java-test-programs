
import java.lang.reflect.ParameterizedType;

public class GetGenericInstanceTest
{

	public static class Abc<T>
	{
		T getInstanceOfT()
		{
			ParameterizedType superClass = (ParameterizedType) getClass().getGenericSuperclass();
			Class<T> type = (Class<T>) superClass.getActualTypeArguments()[0];
			try
			{
				return type.newInstance();
			}
			catch (Exception e)
			{
				// Oops, no default constructor
				throw new RuntimeException(e);
			}
		}
	}
	
	static class SubClass extends Abc<String>
	{
	}

	public static void main(String[] args)
	{
		String instance = new SubClass().getInstanceOfT();
		System.out.println(instance.getClass());
		Integer instance2 = new Abc<Integer>() {}.getInstanceOfT();
		System.out.println(instance2.getClass());
	}

}
