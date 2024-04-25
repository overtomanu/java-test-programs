/*
❯ java --source 21 --enable-preview  OnlyMainTest.java
Note: OnlyMainTest.java uses preview features of Java SE 21.
Note: Recompile with -Xlint:preview for details.
Hello, World!
 */

// commenting as Java 17 is used for time being
/*
void main() {
    System.out.println("Hello, World!");
}
*/

/*
https://www.baeldung.com/java-21-unnamed-class-instance-main
The refined launch protocol chooses automatically a starting point for our program, taking into account both availability and access level.

Instance main() methods should always have a non-private access level. Moreover, the launch protocol follows a specific order to decide which method to use:

     a static void main(String[] args) method declared in the launched class
     a static void main() method declared in the launched class
     a void main(String[] args) instance method declared in the launched class or inherited from a superclass
     a void main() instance method
 */