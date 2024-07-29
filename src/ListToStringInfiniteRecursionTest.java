import java.util.ArrayList;
import java.util.List;

public class ListToStringInfiniteRecursionTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("Element 1");
        list.add(list);
        System.out.println("list is " + list);
        // Output:
        // list is [Element 1, (this Collection)]

        // Python doesn't call __str__ method of its element possibly because of this reason
        // https://stackoverflow.com/questions/1436703/what-is-the-difference-between-str-and-repr#2626364

        // Infinite recursion is not handled when two collections contain each other
        // below code gives StackOverflowError
        List list2 = new ArrayList<>();
        list2.add("List 2 - Element 1");
        list2.add(list);
        list.add(list2);
        System.out.println("list2 is " + list2);
    }
}
