

public class LongLiteralTest {
	
	public static void main(String[] args) {
		Long minusOneLit1 = new Long(-1L);
		Long minOneLit = ((Long)1L);
		//Below declaration does not work, why?
		Long minOneLit2 = ((Long)(-1L));
		Long minusOnePrimLong = -1L;
		System.out.println(minOneLit);
	}

}
