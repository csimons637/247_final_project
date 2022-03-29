import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * @author csimons637
 */
public class DataWriter extends DataConstants {
    
    // Saves users to users.json
    public static void saveUsers() {
        Users users = Users.getInstance();
        ArrayList<User> userList = users.getAllUsers();
        JSONArray JSONUsers = new JSONArray();

        // Creates objects of JSON 
        for (int i = 0; i < userList.size(); i++) {
            JSONUsers.add(getUserJSON(userList.get(i)));
        }

        // Writes the JSON file
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
        userDetails.put(BIRTH, user.getBirthDate());

        ArrayList<Passport> passports = user.getFriends();
        JSONArray JSONPassports = new JSONArray();
        JSONObject JSONPassport = new JSONObject();

        for (Passport p : passports) {
            JSONPassport.put(PASS, p.getUUID());
            JSONPassport.put(FLIGHTS, p.getFlightID());
            JSONPassport.put(SEAT, p.getSeat());
        }

        userDetails.put(FRIENDS, JSONPassports);

        return userDetails;
    }

    // Saves flights to flights.json
    public static void saveFlights() {
        Flights flights = Flights.getInstance();
        ArrayList<Flight> flightList = flights.getAllFlights();
        JSONArray JSONFlights = new JSONArray();

        for (int i = 0; i < flightList.size(); i++) {
            JSONFlights.add(getFlightJSON(flightList.get(i)));
        }
        
        try (FileWriter writer = new FileWriter(TEST)) {
            writer.write(JSONFlights.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getFlightJSON(Flight flight) {
        JSONObject flightDetails = new JSONObject();

        flightDetails.put(FLIGHT_ID, flight.getUUID().toString());
        flightDetails.put(FLIGHT_NUM, flight.getNum());
        flightDetails.put(PLANE, flight.getPlane());
        flightDetails.put(AIRLINE, flight.getAirline());
        flightDetails.put(DEST, flight.getDestination());
        flightDetails.put(DEPART, flight.getDeparture());
        flightDetails.put(DEP_DATE, flight.getDepDate());
        flightDetails.put(DEPART_TIME, flight.getDepTime());
        flightDetails.put(ARRIVAL_TIME, flight.getArrvTime());

        ArrayList<String> seats = flight.getSeats();
        JSONArray JSONSeats = new JSONArray();
        JSONObject JSONSeat = new JSONObject();

        for (String s : seats) {
            JSONSeat.put(SEATS, s);
        }

        flightDetails.put(SEATS, JSONSeat);

        return flightDetails;
    }

    // Save bookings to bookings.json
    public static void saveBookings() {
        Booking booking = Booking.getInstance();
        ArrayList<Booking> bookingList = booking.getBooking();
        JSONArray JSONBookings = new JSONArray();
        
        for (int i = 0; i < bookingList.size(); i++) {
            JSONBookings.add(getBookingJSON(bookingList.get(i)));
        }

        try (FileWriter writer = new FileWriter(TEST)) {
            writer.write(JSONBookings.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static JSONObject getBookingJSON(Booking booking) {
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
