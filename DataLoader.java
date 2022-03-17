import java.io.FileReader;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.UUID;
import java.time.*;

// JSON parsing, objects and arrays
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author csimons637
 */
public class DataLoader extends DataConstants {

    public static ArrayList<Flight> getAllFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();

        try {
            FileReader reader = new FileReader(FLIGHTS_FILE);
            JSONParser parser = new JSONParser();
            JSONArray flightsJSON = (JSONArray)new JSONParser().parse(reader);
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
            return flights;
            reader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void displayFlights(ArrayList<Flight> flights) {
        for (Flight f : flights) {
            System.out.println(f);
        }
    }

    public static void main(String args[]) {

    }

    // Repeat above for flights, hotels, etc.
}
