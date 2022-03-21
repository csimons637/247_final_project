import java.util.ArrayList;
import java.time.*;
import java.util.UUID;

/**
 * @author Christopher Ngo
 * this is a flight and all of its atributes 
 */
public class Flight {
    
    private ArrayList<String> seats;
    private String destination;
    private LocalTime departTime;
    private LocalTime arrivalTime;
    private String departureLoc;

    private UUID uuid;
    private String airline;
    private LocalDate departureDate;
/**
 * Flight constructior 
 * Also creates a new arraaylist for seats JSON
 */


    public Flight (String destination, LocalTime departTime,
    LocalTime arrivalTime, String departureLoc, UUID uuid, String plane,
    String airline, LocalDate departureDate) {

        this.destination = destination;
        this.departTime = departTime;
        this.arrivalTime = arrivalTime;
        this.departureLoc = departureLoc;
        this.uuid = uuid;
        this.airline = airline;
        this.departureDate = departureDate;

        seats = new ArrayList<String>();
    }



  
}
