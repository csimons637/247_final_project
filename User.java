import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;;

abstract class User {
    private UUID userID;
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private Date birthdate;
    private ArrayList<Passport> friends;

    public User(UUID id, String firstName, String lastName, String address, Date birthdate, String email, ArrayList<Passport> friends) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.birthdate = birthdate;
        this.friends = friends;
        this.userID = id;
    }

    public void setFirstName() {

    }

    public void setLastName() {

    }

    public UUID getUUID() {
        return this.userID;
    }
}
