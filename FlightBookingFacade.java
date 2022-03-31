import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FlightBookingFacade {
    private static FlightBookingFacade flightBookings;
    private Flight flights;
    private Hotel hotels;
    
    private FlightBookingFacade() {}

    public static FlightBookingFacade getInstance() {
        if(flightBookings == null) {
            flightBookings = new FlightBookingFacade();
        }
        return flightBookings;
    }

    private ArrayList<Hotel> searchHotel(String dest, String roomType, String room, String gym){
       return Hotels.getInstance().searchHotels(dest, roomType, room, gym);
    }

    private ArrayList<Flight> searchFlight(String source, String dest, Date date){
       return Flights.getInstance().searchFlights(source, dest, date);
    }
    
    public ArrayList<Flight>  bookFlight(String source, String dest, Date date){
        return searchFlight(source, dest, date);
    }

    public ArrayList<Hotel> bookHotel(String dest, String roomType, String pool, String gym){
        return searchHotel(dest, roomType, pool, gym);
    }

    private void checkReservation(){

    }

    public User createAccount(String firstName, String lastName, String username, String address, Date birthdate, String email){
        Users.getInstance().addUser(firstName, lastName, username, address, birthdate, email);
    }
}
