import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerListDemo {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(9, 2, 15, 4, 8, 3, 11, 7, 6, 1));
        int sum = 0, maximum = numbers.get(0);
        for (int number : numbers) {
            sum += number;
            if (number > maximum) maximum = number;
        }
        List<Integer> reversed = new ArrayList<>(numbers);
        Collections.reverse(reversed);
        System.out.println("Numbers: " + numbers);
        System.out.println("Sum: " + sum);
        System.out.println("Maximum: " + maximum);
        System.out.println("Reverse: " + reversed);
    }
}
