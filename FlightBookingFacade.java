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

    private void searchHotel(){

    }

    private void searchFlight(){

    }
    
    private void bookFlight(){

    }

    private void bookHotel(){

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
}
