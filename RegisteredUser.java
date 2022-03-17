package 247_final_project;

import java.util.ArrayList;
import java.util.HashMap;

public class RegisteredUser implements User{
    public String userName;
    public String password;
    public HashMap<String, String> preferences;
    private String email;
    public Passport passport;
    private ArrayList<Passport> guests;
    private String birthdate;
    public int luggage;
    private Trip trip;

    public RegisteredUser(String firstName, String lastName, String address, Passport passport, String birthdate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.passport = passport;
        this.birthdate = birthdate;
    }

    protected void setUserName() {

    }

    protected void setPassword(){

    }

    protected void setBirthDate() {

    }

    protected void setFirstName() {

    }

    protected void setLastName() {

    }

    protected void makePassport() {
        
    }

}
