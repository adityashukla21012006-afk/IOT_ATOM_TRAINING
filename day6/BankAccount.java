public class BankAccount {
    private String accountNumber;
    private String bankName;
    private double balance;

    public BankAccount(String accountNumber, String bankName, double balance) {
        this.accountNumber = accountNumber;
        this.bankName = bankName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}