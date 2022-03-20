import java.util.ArrayList;
import java.util.HashMap;

public class Booking {
    private UUID bookingID;
    private UUID ownerID;
    private ArrayList<UUID> friends = new ArrayList<UUID>();
    private UUID hotel;
    
    public Booking(ArrayList<UUID> flights, UUID hotel,) {
        this.hotel = hotel;
        this.flights = flights;
    }

    public static String toString() {
        String booking;

        return booking;
    }

    public static String getCancellation() {
        String cancelled;
        // Remove booking from JSON
        return cancelled;
    }
}
