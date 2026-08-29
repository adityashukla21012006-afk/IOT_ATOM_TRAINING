class Laptop {
    String brand = "ASUS";
    String model = "TUF A15";

    public void start() {
        System.out.println("Laptop started");
    }

    public void askPassword() {
        System.out.println("Enter your password");
    }

    public static void main(String[] args) {
        Laptop myLaptop = new Laptop();

        System.out.println("Brand: " + myLaptop.brand);
        System.out.println("Model: " + myLaptop.model);

        myLaptop.start();
        myLaptop.askPassword();
    }
}