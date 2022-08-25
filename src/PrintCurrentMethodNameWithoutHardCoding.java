
public class PrintCurrentMethodNameWithoutHardCoding
{
	public static void main(String args[])
	{
		new PrintCurrentMethodNameWithoutHardCoding().doit();
	}

	public void doit()
	{
		System.out.println("|"+Thread.currentThread().getStackTrace()[1].getMethodName()+"|"); // output
																						// :
																						// doit
	}
}