import java.util.ArrayList;
import java.util.Date;

public class Room {
    public String roomNum;
    public String roomType;
    public ArrayList<Date> availabilities = new ArrayList<Date>();
    public ArrayList<Date> daysBooked = new ArrayList<Date>();

    public Room(String roomNum, String roomType, ArrayList<Date> avail){
        this.roomNum = roomNum;
        this.roomType = roomType;
        availabilities = avail;
        daysBooked = null;
    }

    public String getNum() {
        return this.roomNum;
    }
    
    public String getType() {
        return this.roomType;
    }

    public ArrayList<Date> getAvail() {
        return this.availabilities;
    }
}
