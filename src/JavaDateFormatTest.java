
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class JavaDateFormatTest
{
	public static void main(String[] args) throws ParseException
	{
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		String dateStr = "13-05-2022";
		System.out.println("DD-MM-YYYY parsed date: " + 
				sd.parse(dateStr));
		System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(sd.parse(dateStr)));
	}
}
