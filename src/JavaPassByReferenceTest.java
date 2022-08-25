

public class JavaPassByReferenceTest {
	
	public static void main(String[] args) {
		Boolean boolres = new Boolean(false);
		passbyRefBooleanTest(boolres);
		System.out.println("1st:"+boolres);
		Boolean[] boolresArr = new Boolean[1];
		boolresArr[0]=false;
		passbyRefBooleanArrTest(boolresArr);
		System.out.println("2nd:"+boolresArr[0]);
	}

	private static void passbyRefBooleanArrTest(Boolean[] boolresArr) {
		boolresArr[0]=true;
		
	}

	private static void passbyRefBooleanTest(Boolean boolres) {
		boolres=true;
	}

}
