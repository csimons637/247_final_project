import java.util.Date;
import java.util.Scanner;

public class FlightBookingFacade {
    private Flight flights;
    private Hotel hotels;
    private User user;
    private Scanner reader;

    public FlightBookingFacade(Flight flights, Hotel hotels, User user){
        this.flights = flights;
        this.hotels = hotels;
        this.user = user;
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

    private void createAccount(String firstName, String lastName, String username, String address, Date birthdate, String email){
        Users.getInstance().addUser(firstName, lastName, username, address, birthdate, email);

    }
}
