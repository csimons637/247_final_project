import java.util.ArrayList;

public class Bookings {
    private static Bookings booking;
    private ArrayList<Booking> bookings;

    public ArrayList<Booking> getAllBookings(){
        return DataLoader.getAllBookings();
    }

    public static Bookings getInstance() {
        if (booking == null) {
            booking = new Bookings();
        }
        return booking;
    }

    public Bookings getBooking(String keyword) {
        return null;
    }

	public static ArrayList<Booking> getInstance(String userName) {
		return null;
	}

}
