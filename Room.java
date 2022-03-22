import java.util.ArrayList;
import java.time.*;

public class Room {
    public String roomNum;
    public String roomType;
    public ArrayList<LocalDate> availabilities;
    public ArrayList<LocalDate> daysBooked;

    public Room(String roomNum, String roomType, ArrayList<LocalDate> avail){
        this.roomNum = roomNum;
        this.roomType = roomType;
        availabilities = new ArrayList<LocalDate>();
        daysBooked = new ArrayList<LocalDate>();
    }
}
