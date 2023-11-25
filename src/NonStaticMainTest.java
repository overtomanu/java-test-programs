public class NonStaticMainTest {
    // not runnable in Java 17, but should run in Java 21
    // sdk use java 21.0.1-tem
    // java --source 21 --enable-preview  NonStaticMainTest.java
    // output: Hello World!
    public void main(String[] args) {
        System.out.println("Hello World!");
    }
}
