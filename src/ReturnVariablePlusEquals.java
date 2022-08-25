

public class ReturnVariablePlusEquals
{
	public static int returnVariablePlusEquals() {
		int value=10;
		return value+=5;
	}
	
	public static int returnVariablePostIncrement() {
		int value=10;
		return value++;
	}
	public static int returnVariablePreIncrement() {
		int value=10;
		return ++value;
	}
	
	public static void main(String[] args)
	{
		System.out.println("10+=5 is:"+returnVariablePlusEquals());
		System.out.println("10++ is :"+returnVariablePostIncrement());
		System.out.println("++10 is :"+returnVariablePreIncrement());
	}
}
