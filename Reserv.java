import java.util.*;

class Reservation {
    private String trainName;
    private int trainNumber;
    private String classType;
    private String dateOfJourney;
    private String destination;
    private int prn; // Passenger Reservation Number

    // Constructor
    public Reservation(String trainName, int trainNumber, String classType, String dateOfJourney, String destination, int prn) {
        this.trainName = trainName;
        this.trainNumber = trainNumber;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.destination = destination;
        this.prn = prn;
    }

    // Getters
    public String getTrainName() {
        return trainName;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getClassType() {
        return classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getDestination() {
        return destination;
    }

    public int getPrn() {
        return prn;
    }
}

class ReservationSystem {
    private Map<String, String> users; // For storing login credentials
    private Map<Integer, Reservation> reservations; // For storing reservations

    // Constructor
    public ReservationSystem() {
        this.users = new HashMap<>();
        // Sample login credentials (Replace with actual username-password pairs)
        users.put("user1", "password1");
        users.put("user2", "password2");
        this.reservations = new HashMap<>();
    }

    // Method for user login
    public boolean login(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    // Method to make a reservation
    public void makeReservation(String username) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter train name: ");
        String trainName = scanner.nextLine();
        System.out.print("Enter train number: ");
        int trainNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter class type: ");
        String classType = scanner.nextLine();
        System.out.print("Enter date of journey: ");
        String dateOfJourney = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();
        int prn = new Random().nextInt(10000); // Generate a random PRN

        Reservation reservation = new Reservation(trainName, trainNumber, classType, dateOfJourney, destination, prn);
        reservations.put(prn, reservation);
        System.out.println("Reservation successful for " + username + ". Your PRN is: " + prn);
    }

    // Method to cancel a reservation
    public void cancelReservation(int prn) {
        if (reservations.containsKey(prn)) {
            Reservation canceledReservation = reservations.remove(prn);
            System.out.println("Reservation with PRN " + prn + " cancelled successfully.");
            displayReservationDetails(canceledReservation);
        } else {
            System.out.println("Invalid PRN. No reservation found.");
        }
    }

    // Method to display reservation details
    public void displayReservationDetails(Reservation reservation) {
        System.out.println("\nReservation Details:");
        System.out.println("Train Name: " + reservation.getTrainName());
        System.out.println("Train Number: " + reservation.getTrainNumber());
        System.out.println("Class Type: " + reservation.getClassType());
        System.out.println("Date of Journey: " + reservation.getDateOfJourney());
        System.out.println("Destination: " + reservation.getDestination());
        System.out.println("PRN: " + reservation.getPrn());
    }
}

public class Reserv {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationSystem reservationSystem = new ReservationSystem();

        System.out.println("Welcome to the Online Reservation System");

        // Login process
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (reservationSystem.login(username, password)) {
            System.out.println("Login successful!");

            while (true) {
                System.out.println("\nMenu:");
                System.out.println("1. Make a reservation");
                System.out.println("2. Cancel a reservation");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        scanner.nextLine(); // Consume newline
                        reservationSystem.makeReservation(username);
                        break;
                    case 2:
                        System.out.print("Enter PRN to cancel reservation: ");
                        int prn = scanner.nextInt();
                        reservationSystem.cancelReservation(prn);
                        break;
                    case 3:
                        System.out.println("Exiting...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        } else {
            System.out.println("Login failed. Invalid credentials.");
        }
    }
}
