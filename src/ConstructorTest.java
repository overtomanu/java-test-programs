

public class ConstructorTest {
	public String i1 = "val1";
	public String i2 = "val2";
	public String i3;
	public String i4;
	
	public ConstructorTest(){
		i4="defaultConstructor executed";
	}
	
	{
		i3 = "default block executed";
	}
	
	public ConstructorTest(String i2val) {
		i2=i2val;
	}
	
	public static void main(String[] args) {
		ConstructorTest ct =  new ConstructorTest("val3");
		System.out.println(ct.i1+"|"+ct.i2+"|"+ct.i3+"|"+ct.i4);
		ct = new ConstructorTest();
		System.out.println(ct.i1+"|"+ct.i2+"|"+ct.i3+"|"+ct.i4);
	}
	
	{
		i3 = "default block executed2";
	}
	
}
