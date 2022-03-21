import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

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
        return null;
    }

    public static String getCancellation() {
        return null;
    }

    public static String editBooking() {
        return null;
    }
}
