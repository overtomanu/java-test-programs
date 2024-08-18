public class RecordInsideClassAndMethod {
    public record TwoValues<A, B>(A a, B b) {
    }

    public TwoValues<String, String> getValues() {
        return new TwoValues<>("a", "b");
    }

    public Object getValues2() {
        record TwoValuesV2<A, B>(A a, B b) {
        }
        return new TwoValuesV2<>("a", "b");
    }

    public static void main(String[] args) {
        System.out.println(new RecordInsideClassAndMethod().getValues());
        System.out.println(new RecordInsideClassAndMethod().getValues2());
    }
}
