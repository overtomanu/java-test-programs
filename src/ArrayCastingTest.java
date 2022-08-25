


public class ArrayCastingTest {
	
	public static void main(String[] args) {
		Exception[] eArr = new Exception[3];
		eArr[0]= new NullPointerException("ex1");
		eArr[1]= new Exception("ex2");
		eArr[2]= new NullPointerException("ex3");
		
		Object[] exObjArr = (Object[])eArr;
		for(int i=0;i<exObjArr.length;i++)
		{
			System.out.println(exObjArr[i]);
		}
		
		NullPointerException[] eArr2 = new NullPointerException[3];
		eArr2[0]= new NullPointerException("ex1");
		eArr2[1]= new NullPointerException("ex2");
		eArr2[2]= new NullPointerException("ex3");
		
		Exception[] eExcepArr = (Exception[])eArr2;
		for(int i=0;i<eExcepArr.length;i++)
		{
			System.out.println(eExcepArr[i]);
		}
	}

}
