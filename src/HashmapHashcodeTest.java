import java.util.HashMap;
import java.util.Map;

public class HashmapHashcodeTest {
    public static void main(String[] args) {
        Map<User, Address> userAddressMap = new HashMap<>();

        User user999 = new User("User999", 999L);
        userAddressMap.put(user999, new Address("Hollywood"));

        for (Long i = 0L; i < 10000L; i++) {
            userAddressMap.put(new User("User" + i, i), new Address("User" + i + " address"));
        }
        User searchUser = new User("User999", 999L);
        Address addrSearchUser = userAddressMap.get(searchUser);
        System.out.println("address is " + addrSearchUser);
    }
}

class User {
    String name;
    Long id;

    public User(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

class Address {
    String address;

    public Address(String addr) {
        this.address = addr;
    }

    public String getAddress() {
        return this.address;
    }

    @Override
    public String toString() {
        return getAddress();
    }
}