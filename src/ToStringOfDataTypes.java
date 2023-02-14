
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ToStringOfDataTypes
{
	public static void main(String[] args)
	{
		Date date = new Date(System.currentTimeMillis());
		Timestamp timestamp = new Timestamp(2021-1900, 6-1, 22, 20, 39, 31, 0);
		Long long1 = new Long(System.currentTimeMillis());
		BigDecimal bigDecimal = new BigDecimal(System.currentTimeMillis());
		System.out.println("Date:"+date);
		System.out.println("Timestamp-"+timestamp);
		System.out.println("Long:"+long1);
		System.out.println("Bigdecimal:"+bigDecimal);
		System.out.println("Timestamp nano second removed-"+timestamp.toString().split("\\.")[0]);
		System.out.println("int array:"+new int[] {34,44,56});
		System.out.println("Integer array:"+new Integer[] {34,44,56});
		System.out.println(Arrays.deepToString(new int[][] {{3,2,1},{99,54,63},{5}}));
		System.out.println(Arrays.toString(new int[] {8,76,56,44}));
		
		// printing lists
		// arraylist toString prints elements
		List<Integer> arrlist = new ArrayList<>();
		arrlist.add(1);
		arrlist.add(7);
		arrlist.add(13);
		System.out.println("arrlist:"+arrlist);
		
		// whereas list returned by Arrays.asList doesn't print it
		// it seems to print object hash for primitive array
		System.out.println("using Arrays.asList:"+Arrays.asList(new int[] {1,7,14}));
		// but prints correctly for object array
		System.out.println("using Arrays.asList:"+Arrays.asList(new Integer[] {1,7,14}));
		
	}
}
