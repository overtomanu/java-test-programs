public class StringFormatBehaviorForNull {
    public static void main(String[] args) {
        String name = null;
        String name2 = "name2";
        System.out.println(String.format("%s:%s", name, name2));
    }
}
/*
Output:
null:name2
 */