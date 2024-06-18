public class ChainedComparisonOperation {
    public static void main(String[] args) {
        // Chained comparison operator
        int x = 5;
        // below statement gives compilation error
        /*
        java: bad operand types for binary operator '<'
          first type:  boolean
          second type: int
        */
        // this works in python
        // System.out.println(10 < x < 15); // false
        System.out.println(10 < x && x < 15); // true
    }
}
