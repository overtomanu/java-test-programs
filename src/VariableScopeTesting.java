public class VariableScopeTesting {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 30;

        {
            //int a = 40; // error, can't redeclare variable with same name
            a = 40;
            int d = 50;
            System.out.println("Inside block: a = " + a + ", b = " + b + ", c = " + c + ", d = " + d);
        }

        // System.out.println("Outside block: d = " + d); // Error: d is not visible here

        int e = 50;
        System.out.println("Inside main method: a = " + a + ", b = " + b + ", c = " + c + ", e = " + e);
    }
}
