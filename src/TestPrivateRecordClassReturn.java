public class TestPrivateRecordClassReturn {
    private String constAppendStr = "constAppendStr";

    private record SampleRecord7(String attr1, String attr2) {
        SampleRecord7(String attr1, String attr2) {
            // compiler error for below commented statements
            // this is because inner records are implicitly static, like nested classes
            // https://stackoverflow.com/questions/69379298/access-non-static-outer-context-from-within-inner-record
//            this.attr1 = attr1 + constAppendStr;
//            this.attr2 = attr2 + constAppendStr;
            this.attr1 = attr1;
            this.attr2 = attr2;
        }
    }

    public static SampleRecord7 createSampleRecord7() {
        return new SampleRecord7("value1", "value2");
    }

}
