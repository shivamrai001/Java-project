# Railway Reservation System

## 1. Project Title
Railway Reservation System

## 2. Project Overview
A simple command-line railway reservation system implemented in Core Java. The system allows users to view trains, search for trains by route, book tickets (with unique PNR and seat assignment), view booking details, cancel tickets, and view all bookings. The entire application is contained in a single Java file (`Main.java`) for simplicity and ease of submission.

## 3. Features
- View all trains with details (train number, name, source, destination, available seats)
- Search trains by source and destination stations
- Book tickets: generates a unique 8-digit PNR, assigns a seat number, and reduces available seats
- View booking details by PNR (includes passenger info, train details, seat number, status)
- Cancel tickets: updates booking status to CANCELLED and increases available seats
- View all bookings with summary information
- Input validation for numeric choices and basic error handling
- Sequential seat numbering (1 to total seats) for each train

## 4. Technologies Used
- **Language**: Java (Core Java, no external libraries)
- **Development Tools**: 
  - JDK 8 or higher
  - Text editor or IDE (optional, for viewing code)
- **Runtime**: Command-line interface (CLI)
- **Data Storage**: In-memory using Java collections (ArrayList)

## 5. Project Structure
```
Railway-Reservation-System/
├── Main.java          # Single-file Java application containing all classes and logic
└── README.md          # This file
```

The `Main.java` file contains:
- `Train` class (inner class) representing train details
- `Booking` class (inner class) representing booking details
- Main application logic with menu-driven interface
- Methods for initializing data, handling user input, and implementing features

## 6. Prerequisites
- Java Development Kit (JDK) version 8 or higher installed
- Ability to run commands in a terminal/command prompt (CMD, PowerShell, Bash, etc.)
- Basic understanding of running Java programs from command line

## 7. Setup
1. Ensure JDK is installed and `javac`/`java` commands are available in your system PATH.
   - Verify with: `javac -version` and `java -version`
2. Obtain the source code:
   - Option A: Clone this repository: `git clone https://github.com/YOUR_USERNAME/railway-reservation-system.git`
   - Option B: Download `Main.java` directly from the repository
3. Navigate to the project directory containing `Main.java`

## 8. Compile and Run
### Compilation
```cmd
javac Main.java
```
This produces `Main.class` in the same directory.

### Execution
```cmd
java Main
```
The program will start and display the main menu.

## 9. Application Workflow
1. Program starts and initializes sample train data (5 trains with 50 seats each)
2. Main menu is displayed with 7 options
3. User selects an option by entering a number (1-7)
4. Based on the selection, the corresponding function is executed:
   - Options 1, 2, 6: Display information (read-only operations)
   - Options 3, 4, 5: Modify data (booking, viewing, cancellation)
   - Option 7: Exits the program
5. After each operation (except exit), the menu is redisplayed for further actions
6. Program terminates when user selects option 7

## 10. Main Menu
```
========================================
       RAILWAY RESERVATION SYSTEM
========================================
1. View All Trains
2. Search Train
3. Book Ticket
4. View Booking
5. Cancel Ticket
6. View All Bookings
7. Exit

Enter your choice:
```

## 11. Feature Usage
### 1. View All Trains
- Displays a formatted list of all trains
- Shows: Train No, Train Name, Source, Destination, Available Seats

### 2. Search Train
- Prompts for source and destination stations
- Displays trains matching the exact route (case-insensitive)
- Shows same details as "View All Trains" for matching trains
- Displays "No trains found" if no matches

### 3. Book Ticket
- INPUT FOR
  - Train number
  - Passenger name
  - Age
  - Source station
  - Destination station
  - Class (e.g., Sleeper, AC)
- Validates train existence and seat availability
- Generates unique 8-digit PNR
- Assigns seat number (sequential from 1 to total seats)
- Creates booking with status "CONFIRMED"
- Decreases available seats for the selected train
- Displays booking confirmation with all details including seat number

### 4. View Booking
- Prompts for PNR
- Displays complete booking details if found:
  - PNR, Passenger Name, Age
  - Train Number and Name
  - Source and Destination
  - Class
  - Seat Number
  - Status (CONFIRMED/CANCELLED)
- Shows error if PNR not found

### 5. Cancel Ticket
- Prompts for PNR
- Displays booking details if found
- If status is already CANCELLED, shows appropriate message
- Otherwise:
  - Changes status to CANCELLED
  - Increases available seats for the associated train
  - Shows cancellation confirmation

### 6. View All Bookings
- Displays a formatted table of all bookings
- Shows: PNR, Passenger Name, Train No, Source, Destination, Status
- If no bookings exist, displays "No bookings yet"

### 7. Exit
- Displays goodbye message
- Terminates the program

## 12. Sample Output
### Booking a Ticket
```
Enter train number: 12009
Enter passenger name: shivam
Enter age: 20
Enter source station: Bhopal
Enter destination station: New Delhi
Enter class (e.g., Sleeper, AC): Sleeper

Ticket booked successfully!
PNR: 84293107
Train: 12009
Passenger: shivam
Source: Bhopal
Destination: New Delhi
Class: Sleeper
Seat No: 1
Status: CONFIRMED
```

### Viewing a Booking
```
Enter PNR: 84293107

Booking Details:
PNR: 84293107
Passenger: shivam
Age: 20
Train: 12009 (Bhopal Shatabdi)
Source: Bhopal
Destination: New Delhi
Class: Sleeper
Seat No: 1
Status: CONFIRMED
```

### Cancelling a Ticket
```
Enter PNR to cancel: 84293107

Booking found:
PNR: 84293107
Passenger: shivam
Train: 12009 (Bhopal Shatabdi)
Source: Bhopal
Destination: New Delhi
Class: Sleeper
Current Status: CONFIRMED

Ticket cancelled successfully.
Status updated to CANCELLED.
```

## 13. Java Concepts Demonstrated
- **Classes and Objects**: Inner classes `Train` and `Booking` encapsulate data
- **Constructors**: Used to initialize train and booking objects
- **Methods**: Modular design with separate methods for each feature
- **ArrayList**: Dynamic storage for trains and bookings
- **Random**: Generates unique PNR numbers
- **Scanner**: Handles user input from console
- **Exception Handling**: Try-catch for number format validation
- **Conditional Statements**: if-else for validation and flow control
- **Switch Statement**: Main menu navigation
- **Loops**: Iterating over collections for display and search
- **Encapsulation**: Data fields are private to classes, accessed via methods
- **Basic Sorting**: Not used, but data structures support it
- **Memory Management**: Objects created in heap, garbage collected automatically

## 14. Limitations
1. **No Persistence**: All data lost when program exits
2. **Single User**: Designed for sequential use; no concurrency handling
3. **Limited Data Validation**: As noted in section 15
4. **Fixed Sample Data**: Trains hardcoded; no addition/removal of trains
5. **PNR Collision Risk**: Theoretical possibility of duplicate PNR (extremely low with 8-digit random)
6. **No Timing/Scheduling**: Doesn't consider departure/arrival times
7. **No Payment Integration**: Booking is immediate confirmation without payment
8. **Limited Reporting**: No advanced analytics or export features
9. **Platform Dependency**: Relies on console formatting (may vary slightly across terminals)
10. **Scalability**: ArrayList search is O(n); inefficient for large datasets (but fine for demo)

## 15. Future Enhancements
1. **Data Persistence**: Save/load trains and bookings to file (CSV or JSON)
2. **Enhanced Validation**:
   - Realistic station names (from predefined list)
   - Age validation (0-150)
   - Class enumeration (Sleeper, AC, etc.)
   - Route validation (prevent booking mismatched source/destination)
3. **Improved PNR Generation**: 
   - Timestamp-based or sequential to guarantee uniqueness
   - Check for collision and regenerate if needed
4. **Additional Features**:
   - Waiting list when train is full
   - Different classes with different pricing/seat counts
   - Train schedule with timings
   - User authentication and history
   - Admin panel to manage trains
5. **Code Improvements**:
   - Separate classes into multiple files (better organization)
   - Use of enums for fixed values (class types, status)
   - More robust error handling and logging
   - Unit tests with JUnit
6. **User Experience**:
   - Colored output in terminal (using ANSI codes)
   - Better formatting for long station names
   - Help menu or instructions
7. **Advanced Functionality**:
   - Ticket modification (change class, date, etc.)
   - Group bookings
   - Loyalty points/discounts
   - Integration with payment gateways (for real system)

## 16. Author
**shivam rai**
25BAI11241
B.Tech AI/ML Student  
VIT BHOPAL UNIVERSITY 
