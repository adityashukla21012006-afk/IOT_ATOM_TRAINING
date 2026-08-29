import java.util.Scanner;

public class Food_Ordering {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		FoodItem[] sampleItems = {
				new CheesePizza("Cheese Pizza", 101, 250.00, 1),
				new ChickenBurger("Chicken Burger", 201, 180.00, 1),
				new ChickenBiryani("Chicken Biryani", 301, 300.00, 1)
		};

		System.out.println("--- Sample Bills ---");
		for (FoodItem item : sampleItems) {
			item.displayFinalBill();
		}

		boolean ordering = true;
		while (ordering) {
			displayMenu();
			int choice = readInt(scanner, "Enter your choice: ");

			if (choice == 7) {
				ordering = false;
				System.out.println("Thank you for ordering. Goodbye!");
				continue;
			}

			FoodItem selectedItem = createItem(choice, scanner);
			if (selectedItem == null) {
				System.out.println("Invalid choice. Please select a menu item.");
			} else {
				selectedItem.displayFinalBill();
			}
		}

		scanner.close();
	}

	private static void displayMenu() {
		System.out.println("\n--- Food Menu ---");
		System.out.println("1. Cheese Pizza       - Rs. 250.00");
		System.out.println("2. Veggie Pizza       - Rs. 220.00");
		System.out.println("3. Chicken Burger     - Rs. 180.00");
		System.out.println("4. Veggie Burger      - Rs. 150.00");
		System.out.println("5. Chicken Biryani    - Rs. 300.00");
		System.out.println("6. Vegetable Biryani  - Rs. 240.00");
		System.out.println("7. Exit");
	}

	private static FoodItem createItem(int choice, Scanner scanner) {
		FoodItem item;
		switch (choice) {
			case 1:
				item = new CheesePizza("Cheese Pizza", 101, 250.00, 0);
				break;
			case 2:
				item = new VeggiePizza("Veggie Pizza", 102, 220.00, 0);
				break;
			case 3:
				item = new ChickenBurger("Chicken Burger", 201, 180.00, 0);
				break;
			case 4:
				item = new VeggieBurger("Veggie Burger", 202, 150.00, 0);
				break;
			case 5:
				item = new ChickenBiryani("Chicken Biryani", 301, 300.00, 0);
				break;
			case 6:
				item = new VegetableBiryani("Vegetable Biryani", 302, 240.00, 0);
				break;
			default:
				return null;
		}

		int quantity;
		do {
			quantity = readInt(scanner, "Enter quantity: ");
			if (quantity <= 0) {
				System.out.println("Quantity must be greater than zero.");
			}
		} while (quantity <= 0);

		item.quantity = quantity;
		return item;
	}

	private static int readInt(Scanner scanner, String message) {
		System.out.print(message);
		while (!scanner.hasNextInt()) {
			System.out.println("Please enter a valid number.");
			scanner.next();
			System.out.print(message);
		}
		return scanner.nextInt();
	}
}

class FoodItem {
	protected String itemName;
	protected int itemId;
	protected double price;
	protected int quantity;

	FoodItem(String itemName, int itemId, double price, int quantity) {
		this.itemName = itemName;
		this.itemId = itemId;
		this.price = price;
		this.quantity = quantity;
	}

	void displayItemDetails() {
		System.out.println("Item: " + itemName);
		System.out.println("ID: " + itemId);
		System.out.println("Price: Rs. " + String.format("%.2f", price));
		System.out.println("Quantity: " + quantity);
	}

	double calculateTotalPrice() {
		return price * quantity;
	}

	double calculateDiscount() {
		return calculateTotalPrice() * 0.05;
	}

	void displayFinalBill() {
		displayItemDetails();
		double totalPrice = calculateTotalPrice();
		double discount = calculateDiscount();
		System.out.printf("Total price: Rs. %.2f%n", totalPrice);
		System.out.printf("Discount: Rs. %.2f%n", discount);
		System.out.printf("Final bill: Rs. %.2f%n%n", totalPrice - discount);
	}
}

class Pizza extends FoodItem {
	Pizza(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}

	@Override
	double calculateDiscount() {
		return calculateTotalPrice() * 0.10;
	}
}

class CheesePizza extends Pizza {
	CheesePizza(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}

class VeggiePizza extends Pizza {
	VeggiePizza(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}

class Burger extends FoodItem {
	Burger(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}

	@Override
	double calculateDiscount() {
		return calculateTotalPrice() * 0.05;
	}
}

class ChickenBurger extends Burger {
	ChickenBurger(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}

class VeggieBurger extends Burger {
	VeggieBurger(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}

class Biryani extends FoodItem {
	Biryani(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}

	@Override
	double calculateDiscount() {
		return calculateTotalPrice() * 0.08;
	}
}

class ChickenBiryani extends Biryani {
	ChickenBiryani(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}

class VegetableBiryani extends Biryani {
	VegetableBiryani(String itemName, int itemId, double price, int quantity) {
		super(itemName, itemId, price, quantity);
	}
}