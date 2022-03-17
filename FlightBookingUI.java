import java.util.Scanner;

public class FlightBookingUI {
    private static final String STARTUP_MESSAGE = "Welcome Guest!";
    private String[] choices = {"Book a flight", "Book a hotel", "Check any existing reservations",
                                "Change/Cancel any existing reservations", "Login", "Create an account"};
    private Scanner scanner;
    private FlightBooking flightbooking;

    FlightBookingUI(){
        scanner = new Scanner(System.in);
        flightbooking = new FlightBooking();
    }

    private void run() {
        System.out.println(STARTUP_MESSAGE);

        while(true) {
            displayStartup();


        }
    }

    private void displayStartup(){
        System.out.println("\n********** Bon Voyage **********");
        for(int i = 0; i < choices.length; i++){
            System.out.println((i+1) + ". " + choices[i]);
        }
        System.out.println("\n");
    }
}