import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Christopher Ngo
 */
public class Passport {
    public String firstName;
    public String lastName;
    public String address;
    public Date birthDate;
    public ArrayList<UUID> flights;
    public ArrayList<String> seats;

    private UUID passportID;
    public ArrayList<String> passportInfo;

    /**
     * adds parameters for passport
     * @param firstName
     * @param lastName
     * @param address
     * @param birthDate 
     * @param passportNum creates the arraylist for info
     */

public Passport (String firstName, String lastName, String address, Date birthDate, UUID passportID, ArrayList<UUID> flights, ArrayList<String> seats){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.birthDate = birthDate;
    this.passportID = passportID;
    this.flights = flights;
    this.seats = seats;

    passportInfo = new ArrayList<>();
}

public UUID getUUID(){
    return this.passportID;
}

public UUID getFlightID() {
    return flights.get(0);
}

public String getSeat() {
    return this.seats.get(0);
}

}