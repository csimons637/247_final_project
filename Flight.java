import java.util.ArrayList;
import java.util.Date;
import java.time.*;
import java.util.UUID;

/**
 * @author Christopher Ngo
 * this is a flight and all of its atributes 
 */
public class Flight {
    
    private String planeType;
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
        this.planeType = planeType;

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
        output += "\nFlight Number: " + this.flightNumber;
        output += "\nAirline: " + this.airline;
        output += "\nDeparture Location: " + this.departureLoc;
        output += "\nDeparture Date: " + depDate;
        output += "\nDeparture Time: " + depTime;
        output += "\nArrival Location: " + this.destination;
        output += "\nArrival Time: " + arrTime;
        output += "\nSeats:\n" + seats;

        return output;
    }

    public boolean isMatch(String depart, String dest, Date date){
        if (Flights.getInstance().searchFlights(depart, dest, date) == null) {
            return false;
        } else {
            return true;
        }
    }

    public String getNum() {
        return this.flightNumber;
    }

    public String getPlane() {
        return this.planeType;
    }

    public String getAirline() {
        return this.airline;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getDeparture() {
        return this.departureLoc;
    }

    public Date getDepDate() {
        return this.departureDate;
    }

    public LocalTime getDepTime() {
        return this.departTime;
    }

    public LocalTime getArrvTime() {
        return this.arrivalTime;
    }

    public ArrayList<String> getSeats() {
        return this.seats;
    }
}
