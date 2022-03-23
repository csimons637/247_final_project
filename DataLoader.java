import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// JSON parsing, objects and arrays
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class DataLoader extends DataConstants {

    // Parses dates from Strings
    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("MM/dd/yyyy").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static LocalTime parseTime(String time) {
        try {
            return LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // Loads Flights from flights.json
    public static ArrayList<Flight> getAllFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();

        try {
            FileReader reader = new FileReader(FLIGHTS_FILE);
            JSONParser parser = new JSONParser();
            JSONArray flightsJSON = (JSONArray)parser.parse(reader);
            JSONArray flightSeats = (JSONArray)new JSONObject().get(SEATS);
            flightSeats = new JSONArray();
    
            for (int i = 0; i < flightsJSON.size(); i++) {
                JSONObject flightJSON = (JSONObject)flightsJSON.get(i);

                UUID flightID = UUID.fromString((String)flightJSON.get(FLIGHT_ID));
                String flightNumber = (String)flightJSON.get(FLIGHT_NUM);
                String planeType = (String)flightJSON.get(PLANE);
                String airline = (String)flightJSON.get(AIRLINE);
                String dest_airport = (String)flightJSON.get(DEST);
                String dep_airport = (String)flightJSON.get(DEPART);
                Date departDate = parseDate((String)flightJSON.get(DEP_DATE));
                LocalTime depart = parseTime((String)flightJSON.get(DEPART_TIME));
                LocalTime arrive = parseTime((String)flightJSON.get(ARRIVAL_TIME));
                ArrayList<String> seats = new ArrayList<String>();

                for (int j = 0; j < flightSeats.size(); j++) {
                    seats.add((String)flightSeats.get(i));
                }

                flights.add(new Flight(flightID, flightNumber, planeType,
                                airline, dest_airport, dep_airport, departDate,
                                depart, arrive, seats));
                System.out.println(flightID.toString());
            }
            reader.close();
            // return flights;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flights;
    }


    // Loads Hotels (and their rooms) from hotels.json
    public static ArrayList<Hotel> getAllHotels() {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();

        try {
            FileReader reader = new FileReader(HOTELS_FILE);
            JSONParser parser = new JSONParser();
            JSONArray hotelsJSON = (JSONArray)parser.parse(reader);
            
    
            for (int i = 0; i < hotelsJSON.size(); i++) { // Breakpoint
                JSONObject hotelJSON = (JSONObject)hotelsJSON.get(i);
                JSONArray hotelRooms = (JSONArray)hotelJSON.get(ROOMS);
                JSONArray roomAvail = (JSONArray)hotelJSON.get(ROOM_AVAIL);
                hotelRooms = new JSONArray();
                roomAvail = new JSONArray();
                // Hotel Object grabbed from JSON, retrieve details
                UUID hotelID = UUID.fromString((String)hotelJSON.get(HOTEL_ID));
                String hotelName = (String)hotelJSON.get(HOTEL_NAME);
                ArrayList<Room> rooms = new ArrayList<Room>();
    
                for (int j = 0; j < hotelRooms.size(); j++) { // Breakpoint
                    JSONObject hotelRoom = (JSONObject)hotelRooms.get(i);
                    String num = (String)hotelRoom.get(ROOM_NUM);
                    String roomType = (String)hotelRoom.get(ROOM_TYPE);
    
                    ArrayList<Date> avail = new ArrayList<Date>();

                    for (int k = 0; k < roomAvail.size(); k++) { // Breakpoint
                        Date date = parseDate((String)roomAvail.get(k));
                        avail.add(date);
                    }
    
                    rooms.add(new Room(num, roomType, avail));
                }
    
                hotels.add(new Hotel(hotelName, hotelID, rooms));
                System.out.println(hotelID.toString());
            }
            reader.close();
            return hotels;
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return null;
    }


    // Loads Users from users.json
    public static ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE);
            JSONParser parser = new JSONParser();
            JSONArray usersJSON = (JSONArray)parser.parse(reader);
            JSONArray friends = (JSONArray)new JSONObject().get(FRIENDS);

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                ArrayList<Passport> friendIDs = new ArrayList<Passport>();

                UUID userID = UUID.fromString((String)userJSON.get(USER_ID));
                String first = (String)userJSON.get(FIRST);
                String last = (String)userJSON.get(LAST);
                String address = (String)userJSON.get(ADDRESS);
                Date birthdate = parseDate((String)userJSON.get(BIRTH));
                String username = (String)userJSON.get(UNAME);
                String email = (String)userJSON.get(EMAIL);

                for (int j = 0; j < friends.size(); j++) {
                    JSONObject friend = (JSONObject)friends.get(i);
                    Passport friendPass = Passports.getInstance().getPassportByUUID(UUID.fromString((String)friend.get(FRIEND_ID)));

                    friendIDs.add(friendPass);
                }

                users.add(new User(first, last, address, birthdate, email, friendIDs));
            }
            reader.close();
            return users;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // Loads Bookings from bookings.json
    public static ArrayList<Booking> getAllBookings() {
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        try {
            FileReader reader = new FileReader(BOOKING_FILE);
            JSONParser parser = new JSONParser();
            JSONArray bookingsJSON = (JSONArray)parser.parse(reader);
            JSONArray friends = (JSONArray)new JSONObject().get(ADDL_PPL);

            for (int i = 0; i < bookingsJSON.size(); i++) {
                JSONObject bookingJSON = (JSONObject)bookingsJSON.get(i);
                ArrayList<UUID> friendArray = new ArrayList<UUID>();

                UUID bookID = UUID.fromString((String)bookingJSON.get(BOOK));
                UUID ownerID = UUID.fromString((String)bookingJSON.get(OWN));
                UUID hotelID = UUID.fromString((String)bookingJSON.get(HOTEL));

                for (int j = 0; j < friends.size(); j++) {
                    JSONObject friend = (JSONObject)friends.get(i);
                    UUID friendID = UUID.fromString((String)friend.get(FRIEND_ID));
                    friendArray.add(friendID);
                }

                bookings.add(new Booking(bookID, friendArray, hotelID, ownerID));
            }
            reader.close();
            return bookings;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // Loads Friends from friends.json
    public static ArrayList<Passport> getAllFriends() {
        ArrayList<Passport> friends = new ArrayList<Passport>();

        try {
            FileReader reader = new FileReader(FRIENDS_FILE);
            JSONParser parser = new JSONParser();
            JSONArray friendsJSON = (JSONArray)parser.parse(reader);
            JSONArray flightsJSON = (JSONArray)new JSONObject().get(FLIGHTS);
            JSONArray seatsJSON = (JSONArray)new JSONObject().get(SEATS);

            for (int i = 0; i < friendsJSON.size(); i++) {
                JSONObject friendJSON = (JSONObject)friendsJSON.get(i);
                ArrayList<UUID> flights = new ArrayList<UUID>();
                ArrayList<String> seats = new ArrayList<String>();
                UUID pass = UUID.fromString((String)friendJSON.get(PASS));
                String fName = (String)friendJSON.get(FIRST);
                String lName = (String)friendJSON.get(LAST);
                String address = (String)friendJSON.get(ADDRESS);
                Date birth = parseDate((String)friendJSON.get(BIRTH));

                for (int j = 0; j < flightsJSON.size(); j++) {
                    JSONObject flight = (JSONObject)flightsJSON.get(i);
                    UUID flightID = UUID.fromString((String)flight.get(FLIGHT_ID));
                    flights.add(flightID);
                }

                for (int k = 0; k < seatsJSON.size(); k++) {
                    JSONObject seat = (JSONObject)seatsJSON.get(i);
                    String seatNum = (String)seat.get(SEAT);
                    seats.add(seatNum);
                }

                friends.add(new Passport(fName, lName, address, birth, pass, flights, seats));
            }
            reader.close();
            return friends;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String args[]) {
        ArrayList<Hotel> hotels = getAllHotels();

        System.out.println("Hotels: ");
        for (Hotel h : hotels) {
            System.out.println(h);
        }
    }
}
