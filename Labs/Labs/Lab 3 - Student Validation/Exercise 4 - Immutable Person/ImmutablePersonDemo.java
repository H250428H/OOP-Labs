import java.util.ArrayList;
import java.util.List;

public class ImmutablePersonDemo {
    public static void main(String[] args) {
        List<String> langs = new ArrayList<>(List.of("Shona", "English"));
        ImmutablePerson p = new ImmutablePerson("Rudo", 30, langs);
        System.out.println(p);

        langs.add("Ndebele");
        System.out.println("After editing the caller's list: " + p.getLanguages());

        try {
            p.getLanguages().add("French");
        } catch (UnsupportedOperationException e) {
            System.out.println("getLanguages().add() blocked");
        }

        ImmutablePerson older = p.withAge(31);
        System.out.println(p);
        System.out.println(older);
        System.out.println("Same object? " + (p == older));

        try {
            new ImmutablePerson("Baby", -1, List.of());
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        ImmutablePerson twin = new ImmutablePerson("Rudo", 30, List.of("Shona", "English"));
        System.out.println("p equals twin? " + p.equals(twin));
    }
}
