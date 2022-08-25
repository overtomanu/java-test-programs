

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class PrintSystemTime {
	
	public static void main(String[] args) {
		String test="test-";
		test+=System.currentTimeMillis();
		System.out.println(test);
		System.out.println(new SimpleDateFormat("yy-MM-dd-HH-mm-ss-S").format(new Timestamp(System.currentTimeMillis())));
	}

}
