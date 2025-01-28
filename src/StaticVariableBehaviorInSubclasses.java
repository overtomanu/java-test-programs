public class StaticVariableBehaviorInSubclasses {
    public static void main(String[] args) {
        sub1.STATIC_VAR1 = "sub1 value";
        sub2.STATIC_VAR1 = "sub2 value";
        System.out.println("super1.STATIC_VAR1:" + super1.STATIC_VAR1);
        System.out.println("sub1.STATIC_VAR1:" + sub1.STATIC_VAR1);
        System.out.println("sub2.STATIC_VAR1:" + sub2.STATIC_VAR1);
        System.out.println("sub1.getSuperStaticVariable():" + sub1.getSuperStaticVariable());
    }

    class super1 {
        public static String STATIC_VAR1 = "super1 value";
    }

    class sub1 extends super1 {
        public static String STATIC_VAR1 = "sub1 value";

        public static String getSuperStaticVariable() {
            return super1.STATIC_VAR1;
        }
    }

    class sub2 extends super1 {
    }
}

/*
Output:
super1.STATIC_VAR1:sub2 value
sub1.STATIC_VAR1:sub1 value
sub2.STATIC_VAR1:sub2 value
sub1.getSuperStaticVariable():sub2 value
 */
