import java.util.Scanner;

class Car {

    String model = "BMW M3";
    int year = 2024;
    double topSpeed = 250;       // km/h
    double acceleration = 4.1;   // 0-100 km/h in seconds
    double mileage = 12.5;       // km/l

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Car car = new Car();

        System.out.println("===== CAR DETAILS =====");
        System.out.println("Model: " + car.model);
        System.out.println("Year: " + car.year);
        System.out.println("Top Speed: " + car.topSpeed + " km/h");
        System.out.println("Acceleration: " + car.acceleration + " seconds");
        System.out.println("Mileage: " + car.mileage + " km/l");

        System.out.print("\nEnter distance to travel (km): ");
        double distance = sc.nextDouble();

        double time = distance / car.topSpeed;

        double timeInMinutes = time * 60;

        System.out.println("\n===== TRAVEL INFORMATION =====");
        System.out.println("Distance: " + distance + " km");
        System.out.println("Estimated Time: " + timeInMinutes + " minutes");

        sc.close();
    }
}