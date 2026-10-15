import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Tendai");
        names.add("Chipo");
        names.add("Farai");
        names.addFirst("Rudo");

        System.out.println("Size: " + names.size());
        for (String n : names) {
            System.out.println("  " + n);
        }

        LinkedList<Integer> squares = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            squares.add(i * i);
        }
        int sum = 0;
        for (int sq : squares) {
            sum += sq;
        }
        System.out.println("Squares: " + squares + ", sum = " + sum);

        Iterator<String> it1 = names.iterator();
        Iterator<String> it2 = names.iterator();
        System.out.println(it1.next() + ", " + it1.next() + " | " + it2.next());

        try {
            new LinkedList<String>().iterator().next();
        } catch (NoSuchElementException e) {
            System.out.println("Empty list: next() throws NoSuchElementException");
        }
    }
}
