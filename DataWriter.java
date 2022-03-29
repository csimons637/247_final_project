import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author csimons637
 */
public class DataWriter extends DataConstants {
    
    /**
     * COnverts a Date to a String
     * @param date - The date to be converted
     * @return - String representation of date
     */
    public static String toString(Date date) {

        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM-dd-yyyy");

        return dateFormatter.format(date);
    }

    /**
     * Converts a LocalTime to a String
     * @param time - The LocalTime to be converted
     * @return - String representation of time
     */
    public static String toString(LocalTime time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(formatter);
    }

    // Saves users to users.json
    public static void saveUsers() {
        Users users = Users.getInstance();
        ArrayList<User> userList = users.getAllUsers();
        JSONArray JSONUsers = new JSONArray();

        for (int i = 0; i < userList.size(); i++) {
            JSONUsers.add(getUserJSON(userList.get(i)));
        }

        try (FileWriter writer = new FileWriter(TEST)) {
            writer.write(JSONUsers.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();

        userDetails.put(USER_ID, user.getUUID().toString());
        userDetails.put(FIRST, user.getFirstName());
        userDetails.put(LAST, user.getLastName());
        userDetails.put(UNAME, user.getUsername());
        userDetails.put(EMAIL, user.getEmail());
        userDetails.put(ADDRESS, user.getAddress());
        userDetails.put(BIRTH, toString(user.getBirthDate()));

        ArrayList<Passport> passports = user.getFriends();
        JSONArray JSONPassports = new JSONArray();
        JSONObject JSONPassport = new JSONObject();

        for (Passport p : passports) {
            System.out.println(p);
            JSONPassport.put(PASS, p.getUUID());
            JSONPassport.put(FLIGHTS, p.getFlightID());
            JSONPassport.put(SEAT, p.getSeat());
        }

        JSONPassports.add(JSONPassport);

        userDetails.put(FRIENDS, JSONPassports);

        return userDetails;
    }

    /**
     * Writes flight data to flights.json
     */
    public static void saveFlights() {
        Flights flights = Flights.getInstance();
        ArrayList<Flight> flightList = flights.getAllFlights();
        JSONArray JSONFlights = new JSONArray();

        for (int i = 0; i < flightList.size(); i++) {
            JSONFlights.add(getFlightJSON(flightList.get(i)));
        }

        try (FileWriter writer = new FileWriter(FLIGHTS_FILE)) {
            writer.write(JSONFlights.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called by saveFlights() to get flight data
     * @param flight - The flight, who's data is required
     * @return - JSONObject representation of flight
     */
    public static JSONObject getFlightJSON(Flight flight) {
        JSONObject flightDetails = new JSONObject();

        flightDetails.put(FLIGHT_ID, flight.getUUID().toString());
        flightDetails.put(FLIGHT_NUM, flight.getNum());
        flightDetails.put(PLANE, flight.getPlane());
        flightDetails.put(AIRLINE, flight.getAirline());
        flightDetails.put(DEST, flight.getDestination());
        flightDetails.put(DEPART, flight.getDeparture());
        flightDetails.put(DEP_DATE, toString(flight.getDepDate()));
        flightDetails.put(DEPART_TIME, toString(flight.getDepTime()));
        flightDetails.put(ARRIVAL_TIME, toString(flight.getArrvTime()));

        ArrayList<String> seats = flight.getSeats();
        JSONArray JSONSeats = new JSONArray();

        for (String s : seats) {
            JSONSeats.add(s);
        }

        flightDetails.put(SEATS, JSONSeats);

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

    public static void main(String args[]) {
        saveUsers();
    }
}
