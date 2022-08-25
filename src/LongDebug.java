
public class LongDebug {

public static void main(String[] args) {
    Long validValue = 1L; 
    Long invalidValue = -1L;
    Long nullValue = null;

    System.out.println("\nTesting the valid value:");
    testExpectedBehaviour(validValue);
    testUnExpectedBehaviour(validValue);

    System.out.println("\nTesting the invalid value:");
    testExpectedBehaviour(invalidValue);
    testUnExpectedBehaviour(invalidValue);

    System.out.println("\nTesting the null value:");
    testExpectedBehaviour(nullValue);
    testUnExpectedBehaviour(nullValue);
}

/**
 * @param validValue
 */
private static void testExpectedBehaviour(Long value) {
    if (value == null || value == -1) System.out.println("Expected: The value was null or invalid");
    else System.out.println("Expected: The value was valid");
}

private static void testUnExpectedBehaviour(Long value) {
    try {
        if (value == -1 || value == null) System.out.println("Unexpected: The value was null or invalid");
        else System.out.println("Unexpected: The value was valid");
    } catch (NullPointerException e) {
        System.out.println("Unexpected: The system threw an unexpected NullPointerException");
    }
}
}