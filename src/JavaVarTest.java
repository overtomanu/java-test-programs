public class JavaVarTest {
    public static void main(String[] args) {
        var a = 10L;
        System.out.println("a:" + a + ",class=primitive");
        a = 11;
        System.out.println("a:" + a);
        //compiler error for below commented code
        //a = "hello";
    }
}
