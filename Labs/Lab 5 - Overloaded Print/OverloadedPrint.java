import java.util.Arrays;

public class OverloadedPrintDemo {
    static void print(int value) {
        System.out.println("int: " + value);
    }

    static void print(double value) {
        System.out.println("double: " + value);
    }

    static void print(String value) {
        System.out.println("String: " + value);
    }

    static void print(int[] values) {
        System.out.println("int[]: " + Arrays.toString(values));
    }

    public static void main(String[] args) {
        print(42);
        print(3.14);
        print("Java");
        print(new int[] {
            7,
            14,
            21
        });
    }
}
