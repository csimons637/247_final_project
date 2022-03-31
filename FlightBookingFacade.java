import java.util.Date;
import java.util.Scanner;

public class FlightBookingFacade {
    private static FlightBookingFacade flightBookings;
    private Flight flights;
    private Hotel hotels;
    private User users;
    
    private FlightBookingFacade() {}

    public static FlightBookingFacade getInstance() {
        if(flightBookings == null) {
            flightBookings = new FlightBookingFacade();
        }
        return flightBookings;
    }

    private void searchHotel(String dest, String roomType, String ammeneties){
        Hotels.getInstance().searchHotels(dest, roomType, ammeneties);
    }

    private void searchFlight(String source, String dest, Date date){
        Flights.getInstance().searchFlights(source, dest, date);
    }
    
    private void bookFlight(String source, String dest, Date date){
        searchFlight(source, dest, date);
    }

    private void bookHotel(String dest, String roomType, String ammeneties){
        searchHotel(dest, roomType, ammeneties);
    }

    private void checkReservation(){

    }

    private void changeReservation(){

    }

    private void login(){
        
    }

    public User createAccount(String firstName, String lastName, String username, String address, Date birthdate, String email){
        Users.getInstance().addUser(firstName, lastName, username, address, birthdate, email);
    }

    public boolean hasUser(String userName) {
        return hasUser(userName);
    }
}
