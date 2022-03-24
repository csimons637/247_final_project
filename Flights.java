import java.util.ArrayList;
import java.util.UUID;

public class Flights {
    private static Flights flight;
    private ArrayList<Flight> flightsList = new ArrayList<Flight>();

    private Flights() {
        flightsList = DataLoader.getAllFlights();
    }

    public static Flights getInstance(){
        if (flight == null) {
            flight = new Flights();
        }
        return flight;
    }

    public ArrayList<Flight> getAllFlights(){
        return DataLoader.getAllFlights();
    }

    public boolean haveFlight(UUID flightid) {
        return true;
    }

    public Flight getFlightByUUID(UUID flightid){
        for (Flight flight: flightsList) {
            if(flight.getUUID().equals(flightid)) {
                return flight;
            }
        }
        return null;
    }
}
