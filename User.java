import java.util.ArrayList;
import java.util.UUID;

abstract class User {
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private Date birthdate;
    private ArrayList<UUID> friends;

    public User(String firstName, String lastName, String address, Date birthdate, String email, ArrayList<UUID> friends) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.birthdate = birthdate;
        this.friends = friends;
    }

    protected void setFirstName() {

    }

    protected void setLastName() {

    }
}
