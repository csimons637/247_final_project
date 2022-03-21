import java.util.ArrayList;
import java.util.UUID;
import java.time.*;

abstract class User {
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private LocalDate birthdate;
    private ArrayList<Passport> friends;

    public User(String firstName, String lastName, String address, LocalDate birthdate, String email, ArrayList<Passport> friends) {
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
