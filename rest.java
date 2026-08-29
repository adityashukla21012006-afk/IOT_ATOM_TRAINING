import java.util.Scanner;

class RestaurantMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("********************************");
        System.out.println(" Welcome to Abhay Restaurant ");
        System.out.println("********************************");

        System.out.println("1. Veg Menu");
        System.out.println("2. Non-Veg Menu");
        System.out.println("3. Starter Menu");
        System.out.println("4. Dessert Menu");

        System.out.print("\nEnter your choice (1-4): ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("\nVeg Menu");
                System.out.println("1. Paneer Butter Masala");
                System.out.println("2. Veg Biryani");
                System.out.println("3. Masala Dosa");
                break;

            case 2:
                System.out.println("\nNon-Veg Menu");
                System.out.println("1. Chicken Biryani");
                System.out.println("2. Butter Chicken");
                System.out.println("3. Chicken Curry");
                break;

            case 3:
                System.out.println("\nStarter Menu");
                System.out.println("1. French Fries");
                System.out.println("2. Spring Rolls");
                System.out.println("3. Chicken Wings");
                break;

            case 4:
                System.out.println("\nDessert Menu");
                System.out.println("1. Ice Cream");
                System.out.println("2. Gulab Jamun");
                System.out.println("3. Chocolate Brownie");
                break;

            default:
                System.out.println("\nInvalid choice. Please enter a number between 1 and 4.");
        }

        sc.close();
    }
}