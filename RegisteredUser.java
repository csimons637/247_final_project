import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class RegisteredUser extends User {
    public String userName;
    public String password;
    public HashMap<String, String> preferences;
    private String email;
    public Passport passport;
    private ArrayList<Passport> guests;
    private LocalDate birthdate;
    public int luggage;
    private Booking booking;

    public RegisteredUser(String firstName, String lastName, String address, Passport passport, LocalDate birthdate, 
                          String email, ArrayList<Passport> friends ) {
        super(firstName, lastName, address, birthdate, email, friends);
        this.passport = passport;
        this.birthdate = birthdate;
    }

    public void setUserName() {

    }

    public void setPassword(){

    }

    public void setBirthDate() {

    }

    public void setFirstName() {

    }

    public void setLastName() {

    }

    public void makePassport() {
        
    }

}
