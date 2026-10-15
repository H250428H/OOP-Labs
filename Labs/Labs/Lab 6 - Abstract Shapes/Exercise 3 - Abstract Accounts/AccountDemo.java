abstract class Account {
    private final String number;
    protected double balance;

    Account(String number, double openingBalance) {
        this.number = number;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    public abstract double monthlyFee();

    public void applyMonthlyFee() {
        double fee = monthlyFee();
        balance -= fee;
        System.out.printf("%s: fee %.2f charged, balance now %.2f%n", number, fee, balance);
    }

    public String getNumber()  { return number; }
    public double getBalance() { return balance; }
}

class SavingsAccount extends Account {
    private static final double FREE_ABOVE = 1000.0;

    SavingsAccount(String number, double openingBalance) { super(number, openingBalance); }

    @Override
    public double monthlyFee() {
        return balance >= FREE_ABOVE ? 0.0 : 5.0;
    }
}

class CurrentAccount extends Account {
    private static final double FLAT_FEE = 15.0;

    CurrentAccount(String number, double openingBalance) { super(number, openingBalance); }

    @Override
    public double monthlyFee() {
        return FLAT_FEE;
    }
}

public class AccountDemo {
    public static void main(String[] args) {

        Account[] accounts = {
            new SavingsAccount("SAV-001", 400),
            new SavingsAccount("SAV-002", 2500),
            new CurrentAccount("CUR-001", 800)
        };

        for (Account a : accounts) {
            a.deposit(100);
            System.out.printf("%s after deposit: %.2f, monthly fee would be %.2f%n",
                              a.getNumber(), a.getBalance(), a.monthlyFee());
            a.applyMonthlyFee();
            System.out.println("---");
        }
    }
}
