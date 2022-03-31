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
            if(hotel.getUUID().equals(hotel_id)) {
                return hotel;
            }
        }
        return null;
    }

    public ArrayList<Hotel> searchHotels(String dest, String roomType, String pool, String gym) {
        boolean poolA = true;
        boolean gymA = true;

        if (pool.equalsIgnoreCase("true")){
            poolA = true;
        } else {
            poolA = false;
        }

        if (gym.equalsIgnoreCase("true")){
            gymA = true;
        } else {
            gymA = false;
        }

        ArrayList<Hotel> hotels = new ArrayList<Hotel>();
            for(Hotel hotel : hotels) {
                if (hotel.getPool() == poolA && hotel.getGym() ==  gymA) {
                    hotels.add(hotel);
                }
            }
        return hotels;
    }
}
