public class PhonePeUser {
    private String name;
    private String phoneNumber;
    private String upiId;
    private double walletBalance;
    private BankAccount bankAccount;

    public PhonePeUser(String name, String phoneNumber, String upiId, double walletBalance) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.upiId = upiId;
        this.walletBalance = walletBalance;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUpiId() {
        return upiId;
    }

    public double getWalletBalance() {
        return walletBalance;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public boolean addMoneyToWallet(double amount) {
        if (bankAccount != null && bankAccount.withdraw(amount)) {
            walletBalance += amount;
            return true;
        }
        return false;
    }

    public boolean sendMoney(PhonePeUser receiver, double amount) {
        if (amount > 0 && amount <= walletBalance) {
            walletBalance -= amount;
            receiver.walletBalance += amount;
            return true;
        }
        return false;
    }

    public void checkBalance() {
        System.out.println("Wallet Balance: ₹" + walletBalance);

        if (bankAccount != null) {
            System.out.println("Bank Balance: ₹" + bankAccount.getBalance());
        } else {
            System.out.println("No bank account linked.");
        }
    }
}