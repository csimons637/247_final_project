import java.util.Scanner;

public class FlightBookingUI {
    private static final String STARTUP_MESSAGE = "Welcome Guest!";
    private String[] choices = {"Book a flight", "Book a hotel", "Check any existing reservations",
                                "Change/Cancel any existing reservations", "Login", "Create an account",
                                "Quit"};
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
            
            int commandChoice = getUserChoice(choices.length);

            if(commandChoice == -1){
                System.out.println("Invalid command");
                continue;
            }

            if(commandChoice == choices.length -1) break;

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
                    changeReservation();
                    break;
                case(4):
                    login();
                    break;
                case(5):
                    createAccount();
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
}