// from http://www2.cs.arizona.edu/projects/sumatra/hallofshame/
public class JavaBreakinTryReturnInFinally {
	public static void main(String[] args) {
		System.out.println(breakInTryReturnInFinallyInfiniteLoop());
	}
	
	public static int breakInTryReturnInFinallyInfiniteLoop() {
		for (;;) {
			try {
				return 1;
			} finally {
				break;
			}
		}
		return -1;
	}

}
