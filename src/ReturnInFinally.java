

public class ReturnInFinally {
	public static void main(String[] args) {
		System.out.println(finallyReturnTest());
	}
	
	public static String finallyReturnTest() {
		try {
			return "returnStr";
		}finally {
			return "finallyStr";
		}
	}
}
