import java.util.ArrayList;

public class Room {
    public int roomNum;
    public String roomType;
    public ArrayList<Date> availabilities;
    public ArrayList<Date> daysBooked;

    public Room(int roomNum, String roomType, ArrayList<Date> avail){
        this.roomNum = roomNum;
        this.roomType = roomType;
        availabilities = new ArrayList<Date>();
        daysBooked = new ArrayList<Date>();
    }
}
