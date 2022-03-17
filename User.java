import java.util.ArrayList;

abstract class User {
    private String email;
    private Passport passport;
    private ArrayList<Passport> guests;
    public int luggage;

    public User(String firstName, String lastName, String address, Passport passport, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.passport = passport;
        this.birthdate = birthdate;
    }

    protected void setFirstName() {

    }

    protected void setLastName() {

    }

    protected void makePassport() {
        
    }
}