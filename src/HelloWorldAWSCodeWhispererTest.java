import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HelloWorldAWSCodeWhispererTest {
    // AWS code whisperer tryout - after typing below comment, press TAB
    // create program to print hello world
    public static void main(String[] args) {
        System.out.println("Hello World");
        sortList(new ArrayList<>(List.of(998,999,1000,101,1010,1011)));
    }

    // create function to sort list of integers
    public static void sortList(List<Integer> list) {
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
    }
}
