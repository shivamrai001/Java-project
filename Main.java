import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static class Train {
        int trainNumber;
        String trainName;
        String source;
        String destination;
        int availableSeats;

        Train(int trainNumber, String trainName, String source, String destination, int availableSeats) {
            this.trainNumber = trainNumber;
            this.trainName = trainName;
            this.source = source;
            this.destination = destination;
            this.availableSeats = availableSeats;
        }
    }

    static class Booking {
        String pnr;
        String passengerName;
        int age;
        String source;
        String destination;
        String trainNumber;
        String trainName;
        String trainClass;
        String status;

        Booking(String pnr, String passengerName, int age, String source, String destination,
                String trainNumber, String trainName, String trainClass, String status) {
            this.pnr = pnr;
            this.passengerName = passengerName;
            this.age = age;
            this.source = source;
            this.destination = destination;
            this.trainNumber = trainNumber;
            this.trainName = trainName;
            this.trainClass = trainClass;
            this.status = status;
        }
    }

    static List<Train> trains = new ArrayList<>();
    static List<Booking> bookings = new ArrayList<>();
    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeTrains();
        boolean exit = false;
        while (!exit) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");
            switch (choice) {
                case 1:
                    viewAllTrains();
                    break;
                case 2:
                    searchTrain();
                    break;
                case 3:
                    bookTicket();
                    break;
                case 4:
                    viewBooking();
                    break;
                case 5:
                    cancelTicket();
                    break;
                case 6:
                    viewAllBookings();
                    break;
                case 7:
                    exit = true;
                    System.out.println("Thank you for using Railway Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    static void initializeTrains() {
        trains.add(new Train(12001, "Bhopal Shatabdi", "Bhopal", "New Delhi", 50));
        trains.add(new Train(12138, "Punjab Mail", "Mumbai", "New Delhi", 50));
        trains.add(new Train(12627, "Karnataka Express", "New Delhi", "Bengaluru", 50));
        trains.add(new Train(11078, "Jhelum Express", "Pune", "Jammu", 50));
        trains.add(new Train(12804, "VSKP SF Express", "New Delhi", "Visakhapatnam", 50));
    }

    static void printMenu() {
        System.out.println("========================================");
        System.out.println("       RAILWAY RESERVATION SYSTEM");
        System.out.println("========================================");
        System.out.println("1. View All Trains");
        System.out.println("2. Search Train");
        System.out.println("3. Book Ticket");
        System.out.println("4. View Booking");
        System.out.println("5. Cancel Ticket");
        System.out.println("6. View All Bookings");
        System.out.println("7. Exit");
    }

    static int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    static void viewAllTrains() {
        System.out.println("\nList of all trains:");
        System.out.printf("%-10s %-20s %-15s %-15s %s%n", "Train No", "Train Name", "Source", "Destination", "Available Seats");
        for (Train t : trains) {
            System.out.printf("%-10d %-20s %-15s %-15s %d%n", t.trainNumber, t.trainName, t.source, t.destination, t.availableSeats);
        }
        System.out.println();
    }

    static void searchTrain() {
        System.out.print("Enter source station: ");
        String source = scanner.nextLine().trim();
        System.out.print("Enter destination station: ");
        String destination = scanner.nextLine().trim();
        boolean found = false;
        System.out.println("\nMatching trains:");
        System.out.printf("%-10s %-20s %-15s %-15s %s%n", "Train No", "Train Name", "Source", "Destination", "Available Seats");
        for (Train t : trains) {
            if (t.source.equalsIgnoreCase(source) && t.destination.equalsIgnoreCase(destination)) {
                System.out.printf("%-10d %-20s %-15s %-15s %d%n", t.trainNumber, t.trainName, t.source, t.destination, t.availableSeats);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No trains found for the given route.");
        }
        System.out.println();
    }

    static String generatePNR() {
        // Generate an 8-digit numeric PNR
        int pnr = 10000000 + random.nextInt(90000000); // from 10000000 to 99999999
        return String.valueOf(pnr);
    }

    static void bookTicket() {
        System.out.print("Enter train number: ");
        int trainNum = getIntInput("");
        Train train = findTrainByNumber(trainNum);
        if (train == null) {
            System.out.println("Train not found.");
            return;
        }
        System.out.print("Enter passenger name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter age: ");
        int age = getIntInput("");
        System.out.print("Enter source station: ");
        String src = scanner.nextLine().trim();
        System.out.print("Enter destination station: ");
        String dest = scanner.nextLine().trim();
        System.out.print("Enter class (e.g., Sleeper, AC): ");
        String trainClass = scanner.nextLine().trim();

        // Validate that entered source/destination match train's route (optional)
        if (!train.source.equalsIgnoreCase(src) || !train.destination.equalsIgnoreCase(dest)) {
            System.out.println("Warning: Entered source/destination does not match the train's route.");
            // Still allow booking? We'll proceed.
        }

        if (train.availableSeats <= 0) {
            System.out.println("Sorry, no seats available on this train.");
            return;
        }

        String pnr = generatePNR();
        Booking booking = new Booking(pnr, name, age, src, dest,
                String.valueOf(train.trainNumber), train.trainName, trainClass, "CONFIRMED");
        bookings.add(booking);
        train.availableSeats--;

        System.out.println("\nTicket booked successfully!");
        System.out.println("PNR: " + pnr);
        System.out.println("Train: " + train.trainNumber);
        System.out.println("Passenger: " + name);
        System.out.println("Source: " + src);
        System.out.println("Destination: " + dest);
        System.out.println("Class: " + trainClass);
        System.out.println("Status: CONFIRMED\n");
    }

    static Train findTrainByNumber(int trainNumber) {
        for (Train t : trains) {
            if (t.trainNumber == trainNumber) {
                return t;
            }
        }
        return null;
    }

    static Booking findBookingByPNR(String pnr) {
        for (Booking b : bookings) {
            if (b.pnr.equals(pnr)) {
                return b;
            }
        }
        return null;
    }

    static void viewBooking() {
        System.out.print("Enter PNR: ");
        String pnr = scanner.nextLine().trim();
        Booking b = findBookingByPNR(pnr);
        if (b == null) {
            System.out.println("No booking found with PNR: " + pnr);
            return;
        }
        System.out.println("\nBooking Details:");
        System.out.println("PNR: " + b.pnr);
        System.out.println("Passenger: " + b.passengerName);
        System.out.println("Age: " + b.age);
        System.out.println("Train: " + b.trainNumber + " (" + b.trainName + ")");
        System.out.println("Source: " + b.source);
        System.out.println("Destination: " + b.destination);
        System.out.println("Class: " + b.trainClass);
        System.out.println("Status: " + b.status);
        System.out.println();
    }

    static void cancelTicket() {
        System.out.print("Enter PNR to cancel: ");
        String pnr = scanner.nextLine().trim();
        Booking b = findBookingByPNR(pnr);
        if (b == null) {
            System.out.println("No booking found with PNR: " + pnr);
            return;
        }
        System.out.println("\nBooking found:");
        System.out.println("PNR: " + b.pnr);
        System.out.println("Passenger: " + b.passengerName);
        System.out.println("Train: " + b.trainNumber + " (" + b.trainName + ")");
        System.out.println("Source: " + b.source);
        System.out.println("Destination: " + b.destination);
        System.out.println("Class: " + b.trainClass);
        System.out.println("Current Status: " + b.status);

        if (b.status.equalsIgnoreCase("CANCELLED")) {
            System.out.println("Ticket is already cancelled.");
            return;
        }

        // Increase seats on the train
        Train train = findTrainByNumber(Integer.parseInt(b.trainNumber));
        if (train != null) {
            train.availableSeats++;
        }
        b.status = "CANCELLED";
        System.out.println("\nTicket cancelled successfully.");
        System.out.println("Status updated to CANCELLED.\n");
    }

    static void viewAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
            return;
        }
        System.out.println("\nAll Bookings:");
        System.out.printf("%-12s %-15s %-10s %-15s %-15s %s%n", "PNR", "Passenger", "Train No", "Source", "Destination", "Status");
        for (Booking b : bookings) {
            System.out.printf("%-12s %-15s %-10s %-15s %-15s %s%n", b.pnr, b.passengerName, b.trainNumber, b.source, b.destination, b.status);
        }
        System.out.println();
    }
}