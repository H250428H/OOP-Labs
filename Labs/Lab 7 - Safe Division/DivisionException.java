import java.util.Scanner;

public class DivisionExceptionDemo {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            try {
                System.out.print("Enter numerator: ");
                int numerator = Integer.parseInt(input.nextLine().trim());
                System.out.print("Enter denominator: ");
                int denominator = Integer.parseInt(input.nextLine().trim());
                System.out.println("Result: " + (numerator / denominator));
            } catch (NumberFormatException ex) {
                System.out.println("Please enter whole numbers only.");
            } catch (ArithmeticException ex) {
                System.out.println("Cannot divide by zero.");
            }
        }
    }
}
