import java.util.Scanner;

class BankAccount {

    String name;
    double balance;

    BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Current Balance: " + balance);
    }

    void withdraw(double amount) {
        if (amount <= balance) {
            balance = balance - amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Current Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public static void main(String[] args) {
                             
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your initial balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(name, balance);

        System.out.println("\nAccount Holder: " + account.name);
        System.out.println("Initial Balance: " + account.balance);

        System.out.print("\nEnter deposit amount: ");
        double depositAmount = sc.nextDouble();
        account.deposit(depositAmount);

        System.out.print("\nEnter withdrawal amount: ");
        double withdrawAmount = sc.nextDouble();
        account.withdraw(withdrawAmount);

        sc.close();
    }
}