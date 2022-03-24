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

    public RegisteredUser(UUID id, String firstName, String lastName, String address, Date birthdate, 
                          String email, ArrayList<Passport> friends) {
        super(id, firstName, lastName, address, birthdate, email, friends);
        this.birthdate = birthdate;
    }

    protected void setUserName() {

    }

    protected void setPassword(){

    }

    protected void setBirthDate() {

    }

    public void setFirstName() {

    }

    public void setLastName() {

    }

    protected void makePassport() {
        
    }

}
