import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class FlightBookingUI {
    private static final String STARTUP_MESSAGE = "Welcome Guest!";
    private String[] choices = {"Book a flight", "Book a hotel", "Check any existing reservations",
                                "Create an account", "Print Iternary","Quit"};
    private Scanner scanner;
    private FlightBookingFacade flightbooking;

    FlightBookingUI(){
        scanner = new Scanner(System.in);
        flightbooking = FlightBookingFacade.getInstance();
    }

    private void run() {
        System.out.println(STARTUP_MESSAGE);

        while(true) {
            displayStartup();
            
            int commandChoice = getUserChoice(choices.length);

            if(commandChoice == -1){
                System.out.println("Invalid command");
                continue;
            }

            if(commandChoice == choices.length - 1) break;

            switch(commandChoice) {
                case(0):
                    bookFlight();
                    break;
                case(1):
                    bookHotel();
                    break;
                case(2):
                    checkReservation();
                    break;
                case(3):
                    createAccount();
                    break;    
                case(4):
                    printIternary();
                    break;    
            }

        }

        System.out.println("Have a nice day");
    }

    private void displayStartup(){
        System.out.println("\n********** Bon Voyage **********");
        for(int i = 0; i < choices.length; i++){
            System.out.println((i+1) + ". " + choices[i]);
        }
        System.out.println("\n");
    }

    private int getUserChoice(int commands) {
        System.out.print("What would you like to do?");

        String input = scanner.nextLine();
        int choice = Integer.parseInt(input) - 1;

        if(choice >= 0 && choice <= commands - 1)
            return choice;
        
        return -1;
    }

    private void bookFlight() {
        System.out.println("\n------Finding Available Flights------");
        //ask user here from
        System.out.println("\nWhere would you like to leave from?");
        String source = scanner.nextLine();
        // ask where to
        System.out.println("\nWhere are you heading?");
        String dest = scanner.nextLine();
        //ask what day

        Date date = null;

        while(true) {
            System.out.println("\nWhat day would you like to leave?(MM-dd-yyyy)");
            String dateString = scanner.nextLine();
            date = parseDate(dateString);

            if(date != null){
                break;
            }
        }
        ArrayList<Flight> flights = FlightBookingFacade.getInstance().bookFlight(source, dest, date);

        // for(Flight flight: flights) {
        //     System.out.println(flight.toString());
        // }
    }


    private void bookHotel() {
        System.out.println("\n------Finding Available Hotels------");
        
        System.out.println("\nWhere is your final destination?");
        String dest = scanner.nextLine();

        System.out.println("\nWhat type of room would you like?");
        String roomType = scanner.nextLine();

        System.out.println("\nWould you like the hotel to have a pool(Y/N)?");
        String pool = scanner.nextLine();

        System.out.println("\nWould you like the hotel to have a gym(Y/N)?");
        String gym = scanner.nextLine();

       ArrayList<Hotel> hotels = FlightBookingFacade.getInstance().bookHotel(dest, roomType, pool, gym);

        // for(Hotel hotel: hotels) {
        //     System.out.println(hotel.toString());
        // }
    }

    private void checkReservation() {
        System.out.println("\n------What is your user name?------");
        String userName = scanner.nextLine();

        if(!FlightBookingFacade.getInstance().hasUser(userName)) {
            System.out.println("User name not found");
        }

       ArrayList<Booking> bookings = FlightBookingFacade.getInstance().checkReservation(userName);

        for(Booking booking: bookings){
            System.out.println(booking.toString());
        }

    }

    private void createAccount() {
        System.out.println("\n------Let's create an account!------");

        System.out.println("\nPlease enter your first name");
        String firstName = scanner.nextLine();

        System.out.println("\nPlease enter you last name");
        String lastName = scanner.nextLine();

        System.out.println("\nPlease enter a user name");
        String userName = scanner.nextLine();

        System.out.println("\nPlease enter your date of birth (Any format)");
        String birthday = scanner.nextLine();
        Date birthdate = parseDate(birthday);

        System.out.println("\nPlease enter your address");
        String address = scanner.nextLine();

        System.out.println("\nPlease enter your email");
        String email = scanner.nextLine();

        User currentUser = FlightBookingFacade.getInstance().createAccount(firstName,lastName,userName,address,birthdate,email);
        
        System.out.println("Your account has been created!");
    }

    private void printIternary(){
        
        try (FileWriter writer = new FileWriter("itenerary.txt")) {
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FlightBookingUI flightBookingUI = new FlightBookingUI();
        flightBookingUI.run();
    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("MM-dd-yyyy").parse(date);
        } catch (ParseException e) {
            System.out.println("Did not enter the correct format");
            return null;
        }
    }
}