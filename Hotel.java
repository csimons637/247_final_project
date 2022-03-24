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
        return null;
    }

    public String getName() {
        return this.name;
    }
}
