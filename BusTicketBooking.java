import java.util.*;

class InvalidSeatException extends Exception {
    InvalidSeatException(String msg) {
        super(msg);
    }
}

class SeatAlreadyBookedException extends Exception {
    SeatAlreadyBookedException(String msg) {
        super(msg);
    }
}

class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

class BookingNotFoundException extends Exception {
    BookingNotFoundException(String msg) {
        super(msg);
    }
}

class InvalidFareException extends Exception {
    InvalidFareException(String msg) {
        super(msg);
    }
}
abstract class Bus {

    int busNumber;
    String route;
    int seats;
    double fare;

    Bus(int busNumber, String route, int seats, double fare) {
        this.busNumber = busNumber;
        this.route = route;
        this.seats = seats;
        this.fare = fare;
    }

    abstract double calculateFare();

    abstract void busDetails();
}
class ACBus extends Bus {

    ACBus(int busNumber, String route, int seats, double fare) {
        super(busNumber, route, seats, fare);
    }

    double calculateFare() {
        return fare + 100;
    }

    void busDetails() {
        System.out.println("AC Bus: " + busNumber);
        System.out.println("Route: " + route);
        System.out.println("Fare: " + calculateFare());
    }
}
class NonACBus extends Bus {

    NonACBus(int busNumber, String route, int seats, double fare) {
        super(busNumber, route, seats, fare);
    }

    double calculateFare() {
        return fare;
    }

    void busDetails() {
        System.out.println("Non-AC Bus: " + busNumber);
        System.out.println("Route: " + route);
        System.out.println("Fare: " + calculateFare());
    }
}
class Booking {

    private String name;
    private int age;
    private int seatNumber;
    private boolean window;

    static int totalBookings = 0;

    Booking(String name, int age, int seatNumber, boolean window) {
        this.name = name;
        this.age = age;
        this.seatNumber = seatNumber;
        this.window = window;

        totalBookings++;
    }

    void showBooking() {
        System.out.println("Booking ID: " + totalBookings);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Seat: " + seatNumber);
        System.out.println("Window Seat: " + window);
    }
}
public class BusTicketBooking {

    static ArrayList<Integer> bookedSeats = new ArrayList<>();
    static void bookTicket(String name) {
        System.out.println("Ticket booked for " + name);
    }
    static void bookTicket(String name, int seat) {
        System.out.println("Ticket booked for " + name +", Seat: " + seat);
    }
    static void bookTicket(String name, int seat, boolean window) {
        System.out.println("Ticket booked for " + name +", Seat: " + seat +", Window: " + window);
    }
    static void checkSeat(int seat, int totalSeats)
            throws InvalidSeatException, SeatAlreadyBookedException {

        if (seat < 1 || seat > totalSeats) {
            throw new InvalidSeatException("Invalid seat number!");
        }

        if (bookedSeats.contains(seat)) {
            throw new SeatAlreadyBookedException("Seat already booked!");
        }
    }
    public static void main(String[] args) {
        try {
            Bus bus1 = new ACBus(101, "Delhi to Jaipur", 10, 500);
            Bus bus2 = new NonACBus(102, "Delhi to Agra", 10, 300);
            bus1.busDetails();
            System.out.println();

            bus2.busDetails();
            System.out.println();

            checkSeat(2, bus1.seats);

            Booking b1 = new Booking(
                "Aditya", 20, 2, true
            );

            bookedSeats.add(2);

            bookTicket("Aditya", 2, true);

            System.out.println();


            checkSeat(5, bus2.seats);

            Booking b2 = new Booking(
                "Rahul", 21, 5, false
            );

            bookedSeats.add(5);

            bookTicket("Rahul", 5);

            System.out.println();


            b1.showBooking();

            System.out.println();

            try {
                checkSeat(20, bus1.seats);
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            try {
                checkSeat(2, bus1.seats);
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }


            // Invalid age
            try {
                int age = 10;

                if (age < 18) {
                    throw new InvalidAgeException(
                        "Age must be 18 or above!"
                    );
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }


        
            try {

                int cancelSeat = 2;

                if (!bookedSeats.contains(cancelSeat)) {
                    throw new BookingNotFoundException(
                        "Booking not found!"
                    );
                }

                bookedSeats.remove(Integer.valueOf(cancelSeat));

                System.out.println(
                    "Ticket cancelled for seat " + cancelSeat
                );
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }


            
            try {

                double fare = -100;

                if (fare <= 0) {
                    throw new InvalidFareException(
                        "Fare cannot be negative!"
                    );
                }
            }
            catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }


            System.out.println();
            System.out.println(
                "Total Bookings: " + Booking.totalBookings
            );

        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}