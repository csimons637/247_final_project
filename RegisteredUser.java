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
