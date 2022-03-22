import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Christopher Ngo
 */
public class Passport {
    public String firstName;
    public String lastName;
    public String address;
    public LocalDate birthDate;
    public ArrayList<UUID> flights;
    public ArrayList<String> seats;

    private UUID passportNum;
    public ArrayList<String> passportInfo;

    /**
     * adds parameters for passport
     * @param firstName
     * @param lastName
     * @param address
     * @param birthDate 
     * @param passportNum creates the arraylist for info 
     * 
     */

public Passport (String firstName, String lastName, String address, LocalDate birthDate, UUID passportNum, ArrayList<UUID> flights, ArrayList<String> seats){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.birthDate = birthDate;
    this.passportNum = passportNum;
    this.flights = flights;
    this.seats = seats;

    passportInfo = new ArrayList<>();
}




}