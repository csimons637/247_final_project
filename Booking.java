import java.util.ArrayList;
import java.util.HashMap;

public class Booking {
    private UUID bookingID;
    private UUID ownerID;
    private ArrayList<UUID> friends = new ArrayList<UUID>();
    private UUID hotel;
    
    public Booking(UUID booking, ArrayList<UUID> friends, UUID hotel, UUID owner) {
        this.hotel = hotel;
        this.friends = friends;
        this.ownerID = owner;
        this.bookingID = booking;
    }

    public String toString() {
        String booking;

        return booking;
    }

    public static String getCancellation() {
        String cancelled;
        // Remove booking from JSON
        return cancelled;
    }

    public static String editBooking() {
        String edit;
        // Edit booking
        return edit;
    }
}
