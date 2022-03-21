import java.util.ArrayList;

/**
 * @author Christopher Ngo
 */
public class Passport {
    public String firstName;
    public String lastName;
    public String address;
    public String birthDate;

    private String passportNum;
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

public Passport (String firstName, String lastName, String address, String birthDate, String passportNum ){
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.birthDate = birthDate;
    this.passportNum = passportNum;

    passportInfo = new ArrayList<>();
}




}