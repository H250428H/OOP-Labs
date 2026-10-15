import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Book {
    private final String isbn;
    private final String title;

    Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book other)) return false;
        return isbn.equals(other.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() { return title + " [" + isbn + "]"; }
}

class BrokenBook {
    private final String isbn;

    BrokenBook(String isbn) { this.isbn = isbn; }

    @Override
    public boolean equals(Object o) {
        return o instanceof BrokenBook other && isbn.equals(other.isbn);
    }

}

public class BookSetDemo {
    public static void main(String[] args) {
        Book b1 = new Book("978-0134685991", "Effective Java");
        Book b2 = new Book("978-0134685991", "Effective Java, second copy");
        Book b3 = new Book("978-0132350884", "Clean Code");

        System.out.println("b1 == b2      : " + (b1 == b2));
        System.out.println("b1.equals(b2) : " + b1.equals(b2));
        System.out.println("same hashCode : " + (b1.hashCode() == b2.hashCode()));

        Set<Book> shelf = new HashSet<>();
        System.out.println("add b1 -> " + shelf.add(b1));
        System.out.println("add b2 -> " + shelf.add(b2));
        System.out.println("add b3 -> " + shelf.add(b3));
        System.out.println("Set size = " + shelf.size());

        System.out.println("contains Clean Code ISBN? " + shelf.contains(new Book("978-0132350884", "?")));

        BrokenBook x1 = new BrokenBook("111");
        BrokenBook x2 = new BrokenBook("111");
        Set<BrokenBook> broken = new HashSet<>();
        broken.add(x1);
        broken.add(x2);
        System.out.println("BrokenBook equals: " + x1.equals(x2));
        System.out.println("BrokenBook set size = " + broken.size() + "  (should have been 1)");
    }
}
