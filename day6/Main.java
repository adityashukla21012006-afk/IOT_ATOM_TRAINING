public class Main {
    public static void main(String[] args) {

        BankAccount bankA = new BankAccount(
                "ACC001", "SBI", 5000
        );

        BankAccount bankB = new BankAccount(
                "ACC002", "HDFC", 3000
        );

        PhonePeUser userA = new PhonePeUser(
                "User A", "9876543210", "usera@upi", 0
        );

        PhonePeUser userB = new PhonePeUser(
                "User B", "9876543211", "userb@upi", 0
        );

        userA.setBankAccount(bankA);
        userB.setBankAccount(bankB);

        userA.addMoneyToWallet(500);
        userA.sendMoney(userB, 200);

        System.out.println("User A:");
        userA.checkBalance();

        System.out.println();

        System.out.println("User B:");
        userB.checkBalance();
    }
}