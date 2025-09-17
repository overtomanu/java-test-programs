import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CollectorsReturnValueOnEmptyStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Java", null, "Javascript");
        String result = list.stream()
                .filter(Objects::nonNull)
                .filter(str -> !str.contains("Java"))
                .collect(Collectors.joining(", "));
        System.out.println("|" + result + "|"); // Output is empty string
    }
}
