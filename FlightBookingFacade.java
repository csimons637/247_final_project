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

    private void searchAirport(){

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

    private void createAccount(){
        
    }
}
