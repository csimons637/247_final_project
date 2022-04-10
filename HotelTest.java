import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HotelsTest {
    private Hotels hotel = Hotels.getInstance();
    private ArrayList<Hotel> hotelList = hotel.getAllHotels();

    @BeforeEach
    public void setup() {
        hotelList.clear();
        UUID hotelID = UUID.randomUUID();
        ArrayList<Room> rooms = new ArrayList<Room>();
        hotelList.add(new Hotel("Blue Moon", hotelID, rooms, true, true));
        DataWriter.saveHotels();
    }

    @Test
    public void testGetPool() {
        hotelList = DataLoader.getAllHotels();
        assertEquals(true, hotelList.get(0).getPool());
    }

    @Test
    public void testGetHotelName() {
        hotelList = DataLoader.getAllHotels();
        assertEquals("Blue Moon", hotelList.get(0).getName());
    }

    @Test
    public void testBookHotel() {
      Hotels.getInstance().searchHotels("CAE", "single", "false", "true");
      ArrayList<Hotel> hotels =  hotel.searchHotels("CAE", "single", "false", "true");
      assertEquals(hotels, hotelList);
    }
}