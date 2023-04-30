import java.util.Objects;

public record JavaRecordTesting(String name, String address) {
	public JavaRecordTesting {
        Objects.requireNonNull(name);
        Objects.requireNonNull(address);
    }
	public JavaRecordTesting(String name) {
        this(name, "Unknown");
    }
}
