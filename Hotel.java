import java.util.ArrayList;
import java.util.UUID;

public class Hotel {
    private ArrayList<Room> room;
    private String name;
    private UUID uuid;

    public Hotel(String name, UUID uuid) {
        this.uuid = uuid;
        this.name = name;
        room = new ArrayList<Room>();
    }
}
