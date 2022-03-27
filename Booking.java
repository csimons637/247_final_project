import java.util.ArrayList;
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
        String friends= null;
        for (UUID id : this.friends) {
            friends += id.toString();
            friends += '\n';
        }

        String id = this.bookingID.toString() + '\n';
        String owner = this.ownerID.toString() + '\n';
        String hotel = this.hotel.toString();

        String output = "Booking ID: " + id + '\n';
        output += "User ID: " + owner + '\n';
        output += "Guest ID(s): " + friends + '\n';
        output += "Hotel ID: " + hotel;

        return output;
    }

    public static String getCancellation() {
        return null;
    }

    public static String editBooking() {
        return null;
    }
}
