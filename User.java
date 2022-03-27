import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;;

abstract class User {
    private UUID userID;
    private String email;
    private String firstName;
    private String lastName;
    private String username;
    private String address;
    private Date birthdate;
    private ArrayList<Passport> friends;

    public User(UUID id, String firstName, String lastName, String username, String address, Date birthdate, String email, ArrayList<Passport> friends) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.address = address;
        this.email = email;
        this.birthdate = birthdate;
        this.friends = friends;
        this.userID = id;
    }

    public String toString() {
        String output = "User ID: " + this.userID.toString() + '\n';
        output += "Name:" + this.firstName + " ";
        output += this.lastName + '\n';
        output += "Username:" + this.username + '\n';
        output += "Address: " + this.address + '\n';
        output += "Birthdate: " + this.birthdate.toString();

        return output;
    }

    public void setFirstName() {

    }

    public void setLastName() {

    }

    public UUID getUUID() {
        return this.userID;
    }
}
