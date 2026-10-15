import java.util.List;

public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500.00);
        acc.deposit(250.00);
        acc.withdraw(100.00);
        acc.withdraw(5000.00);

        List<String> snapshot = acc.getHistory();
        System.out.println(acc);
        System.out.println("Transactions so far: " + snapshot.size());
        for (String line : snapshot) {
            System.out.println("  " + line);
        }

        try {
            snapshot.add("DEPOSIT 1000000.00");
        } catch (UnsupportedOperationException e) {
            System.out.println("add() blocked: history is read-only");
        }
        try {
            snapshot.clear();
        } catch (UnsupportedOperationException e) {
            System.out.println("clear() blocked: history is read-only");
        }

        acc.deposit(50.00);
        System.out.println("Old snapshot size: " + snapshot.size());
        System.out.println("Fresh history size: " + acc.getHistory().size());
    }
}
