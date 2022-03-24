import java.util.ArrayList;
import java.util.UUID;

public class Hotel {
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private String name;
    private UUID uuid;

    public Hotel(String name, UUID uuid, ArrayList<Room> rooms) {
        this.uuid = uuid;
        this.name = name;
        this.rooms = rooms;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }
}
