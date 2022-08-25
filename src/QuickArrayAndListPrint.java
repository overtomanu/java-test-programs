
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class QuickArrayAndListPrint
{
	public static void main(String[] args)
	{
		int[] arr1 = new int[]
		{
			5, 9, 8, 10, 4, 3
		};
		System.out.println(Arrays.toString(arr1));
		Integer[] intObjArray = new Integer[]
		{
			5, 9, 8, 10, 4, 3
		};
		// cant use int array (array of primitive type) with Arrays.asList
		List<Integer> intList1 = new ArrayList<>(Arrays.asList(intObjArray));
		System.out.println(intList1);
		List<Integer> convertedList = Arrays.stream(arr1).boxed().
				collect(Collectors.toList());
		System.out.println(convertedList);
	}
}
