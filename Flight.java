import java.util.ArrayList;
/**
 * @author Christopher Ngo
 * this is a flight and all of its atributes 
 */
public class Flight {
    
    private ArrayList<String> seats;
    private String destination;
    private Time departTime;
    private Time arrivalTime;
    private String departureLoc;

    private UUID uuid;
    private String airline;
    private Date departureDate
/**
 * Flight constructior 
 * Also creates a new arraaylist for seats JSON
 */


    public Flight (String destination, Time departTime,
    Time arrivalTime, String departureLoc, UUID uuid, String plane,
    String airline, Date departureDate) {

        this.destination = destination;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.departureLoc = departureLoc;
        this.uuid = uuid;
        this.airline = airline;
        this.departureDate = departureDate;

        seat = new ArrayList<String>();
    }



  
}
