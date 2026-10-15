public class BankDemo {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("ACC-001", "Tendai", 500.00);

        try {
            acc.deposit(250.00);
            acc.withdraw(100.00);
            System.out.println("After withdrawing 100: " + acc);

            acc.withdraw(5000.00);
            System.out.println("never printed");
        } catch (InsufficientFundsException e) {
            System.out.println("Withdrawal refused: " + e.getMessage());
            System.out.printf("Short by %.2f%n", e.getShortfall());
        }

        System.out.println(acc);

        try {
            acc.withdraw(-20);
        } catch (InsufficientFundsException e) {
            System.out.println("not reached for a negative amount");
        } catch (IllegalArgumentException e) {
            System.out.println("Bug caught: " + e.getMessage());
        }
    }
}
