import java.util.Objects;

public record JavaRecordTesting(String name, String address) {
	public JavaRecordTesting {
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
    }
	public JavaRecordTesting(String name) {
        this(name, "Unknown");
    }

    public static void main(String[] args) {
        JavaRecordTesting person1Record = new JavaRecordTesting("person1","address1");
        JavaRecordTesting person1Record2 = new JavaRecordTesting("person1","address1");
        System.out.println(person1Record);
        System.out.println(person1Record.address);
        System.out.println(person1Record.address());
        System.out.println(person1Record.hashCode());
        System.out.println(person1Record.getClass());
        System.out.println(person1Record.equals(person1Record2));
        try {
            System.out.println(person1Record.equals(person1Record.clone()));
        } catch (CloneNotSupportedException e) {
            System.out.println("exception message: "+e.getMessage());
        }
        System.out.println(new JavaRecordTesting("person2"));
        //compiler error shown for below line
        //System.out.println(new JavaRecordTesting());
        System.out.println(new JavaRecordTesting("person3",null));
    }
}
