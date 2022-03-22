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
 * Also creates a new arraylist for seats JSON
 */


    public Flight (UUID flightID, int flightNumber, String planeType, String airline, String dest_airport,
        String dep_airport, LocalDate departDate, LocalTime depart, LocalTime arrive, ArrayList<String> seats) {

        this.destination = dest_airport;
        this.departTime = depart;
        this.arrivalTime = arrive;
        this.departureLoc = dep_airport;
        this.uuid = flightID;
        this.airline = airline;
        this.departureDate = departDate;

        this.seats = seats;
}



  
}
