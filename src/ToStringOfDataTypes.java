
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

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
	}
}
