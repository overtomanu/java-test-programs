

public class FinallyTest
{
	public static void main(String[] args) throws Exception
	{
		for (int i = 0; i < 5; i++)
		{
			try
			{
				if (i != 3)
				{
					//break;
					continue;
				}
				throw new Exception("Test 1 |i="+i);
			}
			catch (Exception e)
			{
				System.out.println(e.getMessage());
				throw new Exception("Test 2 | i="+i);
			}
			finally
			{
				System.out.println("Finally called for: " + i);
			}
		}

	}
}
