import java.util.ArrayList;
import java.util.HashMap;

public class Booking {
    private HashMap<String, String> preferences = new HashMap<String, String>();
    private ArrayList<Flight> flights = new ArrayList<Flight>();
    private ArrayList<String> seats = new ArrayList<String>();
    private Hotel hotel;
    private ArrayList<Room> rooms = new ArrayList<Room>();
                                   // First room is primary user's room;
                                   // others are friends' rooms

    public Booking(ArrayList<Flight> flights, Hotel hotel) {
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

    public HashMap<String, String> getPref() {
        return preferences;
    }
}
