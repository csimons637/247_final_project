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

    public void setFirstName(String firstName) {
        this.firstName =firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getUUID() {
        return userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public Date getBirthDate() {
        return this.birthdate;
    }

    public ArrayList getFriends() {
        // This feels wrong, ask Portia
        return this.friends;
    }
}
