import java.util.ArrayList;
import java.util.UUID;

public class Hotels {
    private static Hotels hotel;
    private ArrayList<Hotel> hotels;

    private Hotels() {
        hotels = DataLoader.getAllHotels();
    }

    public static Hotels getInstance() {
        if(hotel == null){
            hotel = new Hotels();
        }
        return hotel;
    }

    public boolean haveHotel(String keyword){
        return true;
    }

    public ArrayList<Hotel> getAllHotels(){
        return DataLoader.getAllHotels();
    }

    public Hotel getHotelByUUID(UUID hotel_id){
        for(Hotel hotel: hotels) {
            
        }
    }
}
