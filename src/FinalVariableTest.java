

public class FinalVariableTest
{
	final String finalVar1;
	
	public FinalVariableTest(String finalVar1)
	{
		super();
		this.finalVar1 = finalVar1;
	}

	/*
	// compile error if you comment above constructor and uncomment below setter method 
	public void setFinalVar1(String value) {
		this.finalVar1=value;
	}
	*/
}
