import java.util.ArrayList;
import java.util.Date;

public class Room {
    public String roomNum;
    public String roomType;
    public ArrayList<Date> availabilities;
    public ArrayList<Date> daysBooked;

    public Room(String roomNum, String roomType, ArrayList<Date> avail){
        this.roomNum = roomNum;
        this.roomType = roomType;
        availabilities = new ArrayList<Date>();
        daysBooked = new ArrayList<Date>();
    }
}
