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

<<<<<<< HEAD
    public String toString(){
        return null;
=======
    public String getName() {
        return this.name;
>>>>>>> a7ebbb63fa4f331a3e0b9c45b6f331c7534f257a
    }
}
