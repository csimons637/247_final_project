import java.util.ArrayList;
import java.util.Date;
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
    private String flightNumber;

    private UUID uuid;
    private String airline;
    private Date departureDate;
/**
 * Flight constructior 
 * Also creates a new arraylist for seats JSON
 */


    public Flight (UUID flightID, String flightNumber, String planeType, String airline, String dest_airport,
        String dep_airport, Date departDate, LocalTime depart, LocalTime arrive, ArrayList<String> seats) {

        this.destination = dest_airport;
        this.departTime = depart;
        this.arrivalTime = arrive;
        this.departureLoc = dep_airport;
        this.uuid = flightID;
        this.airline = airline;
        this.departureDate = departDate;
        this.flightNumber = flightNumber;

        this.seats = seats;
    } 

    public UUID getUUID() {
        return this.uuid;
    }

    public String toString() {
        String depTime = this.departTime.toString();
        String arrTime = this.arrivalTime.toString();
        String depDate = this.departureDate.toString();
        String id = this.uuid.toString();
        String seats = null;
        for (String s : this.seats) {
            seats += s;
            for (int i = 0; i < this.seats.size()-1; i++) {
                seats += ", ";
            }
        }

        String output = "Flight ID: " + id;
        output += "Flight Number: " + this.flightNumber;
        output += "Airline: " + this.airline;
        output += "Departure Location: " + this.departureLoc;
        output += "Departure Date: " + depDate;
        output += "Departure Time: " + depTime;
        output += "Arrival Location: " + this.destination;
        output += "Arrival Time: " + arrTime;
        output += "Seats:\n" + seats;

        return output;
    }
}
