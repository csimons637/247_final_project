import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FlightTests {
    private Flights flights = Flights.getInstance();
    private ArrayList<Flight> flightList = flights.getAllFlights();

    @BeforeEach
    public void prep() {
        flightList.clear();
        UUID flightID = UUID.randomUUID();
        ArrayList<Flights> flights = new ArrayList<Flights>();
        flightList.add(new Flight(flightID, "06942", "787", "Spirit", "CLT", "CAE", "05-12-2022", "9:46", "10:24"));
        DataWriter.saveFlights();
    }

    @Test
    public void testGetDestination() {
        flightList = DataLoader.getAllFlights();
        assertEquals("CLT", flightList.get(0).getDestination());
    }

    @Test
    public void testGetDepart() {
        flightList = DataLoader.getAllFlights();
        assertEquals("CAE", flightList.get(0).getDeparture());
    }

    @Test
    public void testGetAirline() {
        flightList = DataLoader.getAllFlights();
        assertEquals("Spirit", flightList.get(0).getAirline());
    }

    @Test
    public void testGetUUID() {
        flightList = DataLoader.getAllFlights();
        assertEquals(flightID, flightList.get(0).getUUID());
    }

    @Test
    public void testIsMatch() {
        flightList = DataLoader.getAllFlights();
        assertEquals(true, flightList.get(0).isMatch());
    }
}
