import java.util.ArrayList;
import java.util.UUID;

public class Hotel {
    private ArrayList<Room> rooms = new ArrayList<Room>();
    private String name;
    private UUID uuid;
    private boolean hasPool;
    private boolean hasGym;

    public Hotel(String name, UUID uuid, ArrayList<Room> rooms, boolean pool, boolean gym) {
        this.uuid = uuid;
        this.name = name;
        this.rooms = rooms;
        this.hasGym = gym;
        this.hasPool = pool;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public String toString() {
        String id = this.uuid.toString();
        String pool = "1 pool";
        String gym = "1 gym";
        String rooms = null;

        for (Room r : this.rooms) {
            rooms += "Room Number: " + r.getNum() + "\tRoom Type: " + r.getType() + "\n";
        }

        if (!this.hasPool)
            pool = "No pools";
        if (!this.hasGym)
            gym = "No gym";

        String output = id + '\n';
        output += name + '\n';
        output += pool + '\n';
        output += gym + '\n';
        output += rooms;

        return output;
    }

    public String getName() {
        return this.name;
    }
}
