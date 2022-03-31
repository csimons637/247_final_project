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
            return new SimpleDateFormat("MM-dd-yyyy").parse(date);
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
    
            for (int i = 0; i < flightsJSON.size(); i++) {
                JSONObject flightJSON = (JSONObject)flightsJSON.get(i);
                JSONArray flightSeats = (JSONArray)flightJSON.get(SEATS);


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
                    seats.add((String)flightSeats.get(j));
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
            
    
            for (int i = 0; i < hotelsJSON.size(); i++) {
                JSONObject hotelJSON = (JSONObject)hotelsJSON.get(i);
                JSONArray hotelRooms = (JSONArray)hotelJSON.get(ROOMS);
                // Hotel Object grabbed from JSON, retrieve details
                UUID hotelID = UUID.fromString((String)hotelJSON.get(HOTEL_ID));
                String hotelName = (String)hotelJSON.get(HOTEL_NAME);
                Boolean hasPool = (Boolean)hotelJSON.get(POOL);
                Boolean hasGym = (Boolean)hotelJSON.get(GYM);
                ArrayList<Room> rooms = new ArrayList<Room>();
    
                for (int j = 0; j < hotelRooms.size(); j++) {
                    JSONObject hotelRoom = (JSONObject)hotelRooms.get(i);
                    JSONArray roomAvail = (JSONArray)hotelRoom.get(ROOM_AVAIL);
                    String num = (String)hotelRoom.get(ROOM_NUM);
                    String roomType = (String)hotelRoom.get(ROOM_TYPE);
    
                    ArrayList<Date> avail = new ArrayList<Date>();

                    for (int k = 0; k < roomAvail.size(); k++) {
                        Date date = parseDate((String)roomAvail.get(k));
                        avail.add(date);
                    }
    
                    rooms.add(new Room(num, roomType, avail));
                }
    
                hotels.add(new Hotel(hotelName, hotelID, rooms, hasGym, hasPool));
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

            for (int i = 0; i < usersJSON.size(); i++) {
                JSONObject userJSON = (JSONObject)usersJSON.get(i);
                JSONArray friends = (JSONArray)userJSON.get(FRIENDS);
                ArrayList<Passport> passports = new ArrayList<Passport>();

                UUID userID = UUID.fromString((String)userJSON.get(USER_ID));
                String first = (String)userJSON.get(FIRST);
                String last = (String)userJSON.get(LAST);
                String address = (String)userJSON.get(ADDRESS);
                Date birthdate = parseDate((String)userJSON.get(BIRTH));
                String username = (String)userJSON.get(UNAME);
                String email = (String)userJSON.get(EMAIL);

                for (int j = 0; j < friends.size(); j++) {
                    JSONObject friend = (JSONObject)friends.get(j);
                    Passport friendPass = Passports.getInstance().getPassportsByUUID(UUID.fromString((String)friend.get(PASSPORT_ID)));

                    passports.add(friendPass);
                }

                users.add(new RegisteredUser(userID, first, last, username, address, birthdate, email, passports));
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

            for (int i = 0; i < bookingsJSON.size(); i++) {
                JSONObject bookingJSON = (JSONObject)bookingsJSON.get(i);
                ArrayList<UUID> friendArray = new ArrayList<UUID>();

                UUID bookID = UUID.fromString((String)bookingJSON.get(BOOK));
                UUID ownerID = UUID.fromString((String)bookingJSON.get(OWN));
                UUID hotelID = UUID.fromString((String)bookingJSON.get(HOTEL));

                JSONArray friends = (JSONArray)bookingJSON.get(ADDL_PPL);

                for (int j = 0; j < friends.size(); j++) {
                    JSONObject friend = (JSONObject)friends.get(j);
                    UUID friendID = UUID.fromString((String)friend.get(PASSPORT_ID));
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
    public static ArrayList<Passport> getAllPassports() {
        ArrayList<Passport> passports = new ArrayList<Passport>();

        try {
            FileReader reader = new FileReader(PASSPORTS_FILE);
            JSONParser parser = new JSONParser();
            JSONArray passportsJSON = (JSONArray)parser.parse(reader);

            for (int i = 0; i < passportsJSON.size(); i++) {
                JSONObject passportJSON = (JSONObject)passportsJSON.get(i);
                JSONArray flightsJSON = (JSONArray)passportJSON.get(FLIGHTS);
                JSONArray seatsJSON = (JSONArray)passportJSON.get(SEATS);
                ArrayList<UUID> flights = new ArrayList<UUID>();
                ArrayList<String> seats = new ArrayList<String>();
                UUID passport = UUID.fromString((String)passportJSON.get(PASS));
                String fName = (String)passportJSON.get(FIRST);
                String lName = (String)passportJSON.get(LAST);
                String address = (String)passportJSON.get(ADDRESS);
                Date birth = parseDate((String)passportJSON.get(BIRTH));

                for (int j = 0; j < flightsJSON.size(); j++) {
                    JSONObject flight = (JSONObject)flightsJSON.get(j);
                    UUID flightID = UUID.fromString((String)flight.get(FLIGHT_ID));
                    flights.add(flightID);
                }
                for (int k = 0; k < seatsJSON.size(); k++) {
                    JSONObject seat = (JSONObject)seatsJSON.get(k);
                    String seatNum = (String)seat.get(SEAT);
                    seats.add(seatNum);
                }

                passports.add(new Passport(fName, lName, address, birth, passport, flights, seats));
            }
            reader.close();
            return passports;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
