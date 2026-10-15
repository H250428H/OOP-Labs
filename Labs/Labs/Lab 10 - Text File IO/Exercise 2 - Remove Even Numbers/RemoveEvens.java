import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.function.Predicate;

public class RemoveEvens {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
        System.out.println("Before: " + numbers);

        Predicate<Integer> isEven = n -> n % 2 == 0;

        boolean changed = numbers.removeIf(isEven);
        System.out.println("After:  " + numbers + "   (anything removed? " + changed + ")");

        try {
            List.of(2, 4, 6).removeIf(isEven);
        } catch (UnsupportedOperationException e) {
            System.out.println("List.of(...) is immutable: removeIf is not allowed");
        }

        List<Integer> broken = new ArrayList<>(List.of(1, 2, 3, 4));
        try {
            for (Integer n : broken) {
                if (n % 2 == 0) {
                    broken.remove(n);
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("for-each + remove() throws ConcurrentModificationException");
        }
    }
}
