import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.attribute.standard.JobStateReasons;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author csimons637
 */
public class DataWriter extends DataConstants {
    
    // Saves users to users.json
    public static void saveUsers() {

    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();

        return userDetails;
    }


    // Saves flights to flights.json
    public static void saveFlights() {

    }

    public static JSONObject getFlightJSON(Flight flight) {
        JSONObject flightDetails = new JSONObject();

        return flightDetails;
    }


    // Save bookings to bookings.json
    public static void saveBookings(Booking booking) {
    }

    public static JSONObject getBookingJSON() {
        JSONObject bookingDetails = new JSONObject();

        return bookingDetails;
    }


    // Save hotels to hotels.json
    public static void saveHotels() {

    }

    public static JSONObject getHotelJSON(Hotel hotel) {
        JSONObject hotelDetails = new JSONObject();

        return hotelDetails;
    }

    // Repeat above for flights, hotels, etc.
}
