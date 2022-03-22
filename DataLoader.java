import java.io.FileReader;

import java.util.ArrayList;
import java.util.UUID;
import java.time.*;

// JSON parsing, objects and arrays
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class DataLoader extends DataConstants {

    // Loads Flights from flights.json
    public static ArrayList<Flight> getFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();

        try {
            FileReader reader = new FileReader(FLIGHTS_FILE);
            JSONParser parser = new JSONParser();
            JSONArray flightsJSON = (JSONArray)parser.parse(reader);
            JSONArray flightSeats = (JSONArray)new JSONObject().get(SEATS);
    
            for (int i = 0; i < flightsJSON.size(); i++) {
                JSONObject flightJSON = (JSONObject)flightsJSON.get(i);

                UUID flightID = UUID.fromString((String)flightJSON.get(FLIGHT_ID));
                int flightNumber = (int)flightJSON.get(FLIGHT_NUM);
                String planeType = (String)flightJSON.get(PLANE);
                String airline = (String)flightJSON.get(AIRLINE);
                String dest_airport = (String)flightJSON.get(DEST);
                String dep_airport = (String)flightJSON.get(DEPART);
                LocalDate departDate = (LocalDate)flightJSON.get(DEP_DATE);
                LocalTime depart = (LocalTime)flightJSON.get(DEPART_TIME);
                LocalTime arrive = (LocalTime)flightJSON.get(ARRIVAL_TIME);
                ArrayList<String> seats = new ArrayList<String>();

                for (int j = 0; j < flightSeats.size(); j++) {
                    String seatNum = (String)flightSeats.get(i);
                    seats.add(seatNum);
                }

                flights.add(new Flight(flightID, flightNumber, planeType,
                                airline, dest_airport, dep_airport, departDate,
                                depart, arrive, seats));
            }
            reader.close();
            return flights;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // Loads Hotels (and their rooms) from hotels.json
    public static ArrayList<Hotel> getHotels() {
        ArrayList<Hotel> hotels = new ArrayList<Hotel>();

        try {
            FileReader reader = new FileReader(HOTELS_FILE);
            JSONParser parser = new JSONParser();
            JSONArray hotelsJSON = (JSONArray)parser.parse(reader);
            JSONArray hotelRooms = (JSONArray)new JSONObject().get(ROOMS);
            JSONArray roomAvail = (JSONArray)new JSONObject().get(ROOM_AVAIL);
    
            for (int i = 0; i < hotelsJSON.size(); i++) {
                JSONObject hotelJSON = (JSONObject)hotelsJSON.get(i);
                // Hotel Object grabbed from JSON, retrieve details
                UUID hotelID = UUID.fromString((String)hotelJSON.get(HOTEL_ID));
                String hotelName = (String)hotelJSON.get(HOTEL_NAME);
                ArrayList<Room> rooms = new ArrayList<Room>();
    
                for (int j = 0; j < hotelRooms.size(); j++) {
                    JSONObject hotelRoom = (JSONObject)hotelRooms.get(i);
                    String num = (String)hotelRoom.get(ROOM_NUM);
                    String roomType = (String)hotelRoom.get(ROOM_TYPE);
    
                    ArrayList<LocalDate> avail = new ArrayList<LocalDate>();
                    avail = (ArrayList<LocalDate>)roomAvail; // Should cast the JSONArray to ArrayList<String>
    
                    Room room = new Room(num, roomType, avail);
                    rooms.add(room);
                }
    
                hotels.add(new Hotel(hotelName, hotelID));
            }
            reader.close();
            return hotels;
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return null;
    }


    // Loads Users from users.json
    public static ArrayList<User> getUsers() {
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
                LocalDate birthdate = (LocalDate)userJSON.get(BIRTH);
                String username = (String)userJSON.get(UNAME);
                String email = (String)userJSON.get(EMAIL);

                for (int j = 0; j < friends.size(); j++) {
                    JSONObject friend = (JSONObject)friends.get(i);
                    UUID friendID = UUID.fromString((String)friend.get(FRIEND_ID));
                    friendIDs.add(getPassportByUUID(friendID));
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
    public static ArrayList<Booking> getBookings() {
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
    public static ArrayList<Passport> getFriends() {
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
                LocalDate birth = (LocalDate)friendJSON.get(BIRTH);

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

    }

    // Repeat above for flights, hotels, etc.
}
