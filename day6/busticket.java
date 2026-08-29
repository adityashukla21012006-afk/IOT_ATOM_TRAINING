// Custom Exceptions
class InvalidSeatException extends Exception { public InvalidSeatException(String m){ super(m); } }
class SeatAlreadyBookedException extends Exception { public SeatAlreadyBookedException(String m){ super(m); } }
class InvalidAgeException extends Exception { public InvalidAgeException(String m){ super(m); } }
class BookingNotFoundException extends Exception { public BookingNotFoundException(String m){ super(m); } }
class InvalidFareException extends Exception { public InvalidFareException(String m){ super(m); } }

abstract class Bus {
    String busNumber, route;
    int totalSeats;
    double baseFare;
    boolean[] seats; // array to store booking status

    Bus(String busNumber, String route, int totalSeats, double baseFare) throws InvalidFareException {
        if (baseFare <= 0) throw new InvalidFareException("Fare must be > 0");
        this.busNumber = busNumber; this.route = route;
        this.totalSeats = totalSeats; this.baseFare = baseFare;
        this.seats = new boolean[totalSeats];
    }
    abstract double calculateFare();
    abstract void showBusDetails();
}

class ACBus extends Bus {
    ACBus(String no, String route, int seats, double fare) throws InvalidFareException { super(no,route,seats,fare); }
    @Override double calculateFare() { return baseFare * 1.5 + 200; }
    @Override void showBusDetails() { System.out.println("AC Bus " + busNumber + " Route: " + route + " Fare: " + calculateFare()); }
}

class NonACBus extends Bus {
    NonACBus(String no, String route, int seats, double fare) throws InvalidFareException { super(no,route,seats,fare); }
    @Override double calculateFare() { return baseFare; }
    @Override void showBusDetails() { System.out.println("Non-AC Bus " + busNumber + " Route: " + route + " Fare: " + calculateFare()); }
}

class Passenger {
    private String name; private int age; private int seatNo; private boolean windowPref;
    private static int totalBookings = 0;
    private int bookingId;

    Passenger(String name, int age) throws InvalidAgeException {
        if(age <=0 || age > 100) throw new InvalidAgeException("Invalid age: "+age);
        this.name = name; this.age = age;
        this.bookingId = ++totalBookings;
    }
    public int getBookingId(){ return bookingId; }
    public int getSeatNo(){ return seatNo; }
    public void setSeatNo(int s){ seatNo = s; }
    public static int getTotalBookings(){ return totalBookings; }
    @Override public String toString(){ return "BookingID: "+bookingId+" Name: "+name+" Age: "+age+" Seat: "+seatNo; }
}

class BookingSystem {
    Bus bus;
    Passenger[] bookings; // use arrays to store objects
    int count = 0;
    BookingSystem(Bus bus){ this.bus = bus; bookings = new Passenger[bus.totalSeats]; }

    // Overloading
    void bookTicket(String name, int age, int seatNo) throws Exception { bookTicket(name, age, seatNo, false); }
    void bookTicket(String name, int seatNo) throws Exception { bookTicket(name, 25, seatNo, false); }
    void bookTicket(String name, int age, int seatNo, boolean windowPref) throws Exception {
        if(seatNo <0 || seatNo >= bus.totalSeats) throw new InvalidSeatException("Seat "+seatNo+" invalid");
        if(bus.seats[seatNo]) throw new SeatAlreadyBookedException("Seat "+seatNo+" already booked");
        Passenger p = new Passenger(name, age);
        p.setSeatNo(seatNo);
        bus.seats[seatNo] = true;
        bookings[count++] = p;
        System.out.println("Booked: " + p);
    }
    void cancelTicket(int bookingId) throws BookingNotFoundException {
        for(int i=0;i<count;i++){
            if(bookings[i]!=null && bookings[i].getBookingId()==bookingId){
                bus.seats[bookings[i].getSeatNo()] = false;
                System.out.println("Cancelled: "+bookingId);
                bookings[i]=null; return;
            }
        }
        throw new BookingNotFoundException("Booking ID "+bookingId+" not found");
    }
}

class BusTicketDemo {
    public static void main(String[] args) {
        try{
            Bus b1 = new ACBus("KA01-123", "BLR-MYS", 5, 500);
            Bus b2 = new NonACBus("KA02-456", "BLR-CHN", 5, 300);

            b1.showBusDetails(); // runtime polymorphism using Bus ref
            b2.showBusDetails();

            BookingSystem system = new BookingSystem(b1);
            system.bookTicket("Amit", 22, 1, true);
            system.bookTicket("Rahul", 2); // overloaded
            system.bookTicket("Priya", 30, 1); // SeatAlreadyBookedException

        } catch(Exception e){ System.out.println("Error: "+e.getMessage()); }

        try{
            Bus b = new ACBus("KA03", "Test", 3, 400);
            BookingSystem s = new BookingSystem(b);
            s.bookTicket("Test", 150, 0); // InvalidAgeException
            s.bookTicket("Test2", 10, 10); // InvalidSeatException
            s.cancelTicket(99); // BookingNotFoundException
            Bus bInvalid = new ACBus("X","Y",5,-100); // InvalidFareException
        } catch(Exception e){ System.out.println("Handled: "+e.getMessage()); }

        System.out.println("Total bookings: "+Passenger.getTotalBookings());
    }
}