import java.util.ArrayList;

abstract class User {
    private String email;
    private String firstName;
    private String lastName;
    private String address;
    private Date birthdate;

    public User(String firstName, String lastName, String address, Date birthdate, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.birthdate = birthdate;
    }

    protected void setFirstName() {

    }

    protected void setLastName() {

    }

    protected void makePassport() {
        
    }
}
