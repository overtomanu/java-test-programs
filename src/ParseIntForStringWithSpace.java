public class ParseIntForStringWithSpace {

    public static void main(String[] args) {
        // throws exception
        System.out.println(Integer.parseInt("0 "));
        // below one also throws exception
        // System.out.println(Integer.parseInt("0 1"));
    }
}
