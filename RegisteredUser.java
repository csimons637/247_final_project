import java.util.Date;
import java.util.UUID;
import java.util.ArrayList;
import java.util.HashMap;

public class RegisteredUser extends User {
    private UUID userID;
    private String userName;
    private String password;
    private HashMap<String, String> preferences;
    private String email;
    private ArrayList<Passport> guests;
    private Date birthdate;
    private int luggage;
    private Booking booking;

    public RegisteredUser(UUID id, String firstName, String lastName, String username, String address, Date date, 
                          String email, ArrayList<Passport> friends) {
        super(id, firstName, lastName, username, address, date, email, friends);
        this.birthdate = date;
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
