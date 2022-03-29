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

    /**
     * Writes user data to users.json
     */
    public static void saveUsers() {
        Users users = Users.getInstance();
        ArrayList<User> userList = users.getAllUsers();
        JSONArray JSONUsers = new JSONArray();

        for (int i = 0; i < userList.size(); i++) {
            JSONUsers.add(getUserJSON(userList.get(i)));
        }

        try (FileWriter writer = new FileWriter(USER_TEST)) {
            writer.write(JSONUsers.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called by saveUsers() to get User data
     * @param user - The User who's data is needed
     * @return - JSONObject representation of user
     */
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
            JSONPassport.put(PASS, p.getUUID().toString());
            JSONPassport.put(FLIGHTS, p.getFlightID().toString());
            JSONPassport.put(SEAT, p.getSeat());

            JSONPassports.add(JSONPassport);
            userDetails.put(FRIENDS, JSONPassports);
    
        }

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

        try (FileWriter writer = new FileWriter(FLIGHT_TEST)) {
            writer.write(JSONFlights.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called by saveFlights() to get Flight data
     * @param flight - The Flight, who's data is needed
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
    public static void saveBookings() {
        Booking booking = Booking.getInstance();
        ArrayList<Booking> bookingList = booking.getBooking();
        JSONArray JSONBookings = new JSONArray();
        
        for (int i = 0; i < bookingList.size(); i++) {
            JSONBookings.add(getBookingJSON(bookingList.get(i)));
        }

        try (FileWriter writer = new FileWriter(BOOKING_TEST)) {
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
        Hotels hotels = Hotels.getInstance();
        ArrayList<Hotel> hotelList = hotels.getAllHotels();
        JSONArray JSONHotels = new JSONArray();

        for (int i = 0; i < hotelList.size(); i++) {
            JSONHotels.add(getHotelJSON(hotelList.get(i)));
        }

        try (FileWriter writer = new FileWriter(HOTEL_TEST)) {
            writer.write(JSONHotels.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getHotelJSON(Hotel hotel) {
        JSONObject hotelDetails = new JSONObject();

        hotelDetails.put(HOTEL_ID, hotel.getUUID().toString());
        hotelDetails.put(HOTEL_NAME, hotel.getName());
        hotelDetails.put(POOL, hotel.getPool());
        hotelDetails.put(GYM, hotel.getGym());

        ArrayList<Room> rooms = hotel.getRooms();
        JSONArray JSONRooms = new JSONArray();
        JSONArray JSONRoomAvail = new JSONArray();
        JSONObject JSONRoom = new JSONObject();

        for (Room r : rooms) {
            ArrayList<Date> avail = r.getAvail();
            for (Date d : avail) {
                JSONRoomAvail.add(toString(d));
            }
            JSONRoom.put(ROOM_NUM, r.getNum());
            JSONRoom.put(ROOM_TYPE, r.getType());
            JSONRoom.put(ROOM_AVAIL, JSONRoomAvail);
            JSONRooms.add(JSONRoom);
            hotelDetails.put(ROOMS, JSONRooms);
        }

        return hotelDetails;
    }

    // Repeat above for flights, hotels, etc.

    public static void main(String args[]) {
        saveUsers();
        saveFlights();
        saveHotels();
        // saveBookings();
    }
}
