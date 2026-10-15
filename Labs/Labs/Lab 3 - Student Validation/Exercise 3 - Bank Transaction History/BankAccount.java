import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private final String accountNumber;
    private String ownerName;
    private double balance;

    private final List<String> history = new ArrayList<>();

    public BankAccount(String accountNumber, String ownerName, double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Opening balance cannot be negative");
        }
        this.accountNumber = accountNumber;
        setOwnerName(ownerName);
        this.balance = openingBalance;
        history.add(String.format("OPENED    %9.2f   balance %9.2f", openingBalance, balance));
    }

    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName()     { return ownerName; }
    public double getBalance()       { return balance; }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.isBlank()) {
            throw new IllegalArgumentException("Owner name required");
        }
        this.ownerName = ownerName.trim();
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
        history.add(String.format("DEPOSIT   %9.2f   balance %9.2f", amount, balance));
    }

    public boolean withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            history.add(String.format("DECLINED  %9.2f   insufficient funds", amount));
            return false;
        }
        balance -= amount;
        history.add(String.format("WITHDRAW  %9.2f   balance %9.2f", amount, balance));
        return true;
    }

    public List<String> getHistory() {
        return List.copyOf(history);
    }

    @Override
    public String toString() {
        return String.format("%s [%s] balance: %.2f", accountNumber, ownerName, balance);
    }
}
