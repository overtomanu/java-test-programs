

public class StaticMethodOverrideTest {
	
	public static class Super{
		public static String strReturner() {
			return "Super";
		}
	}
	
	public static class Sub extends Super{
		//compile error
		/*public String strReturner() {
			return "SubInstance";
		}*/
	}

}
