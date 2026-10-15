import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of(
            "Tendai", "Chipo", "Farai", "Tendai", "Rudo", "Chipo", "Nyasha", "Farai"));
        System.out.println("Original:           " + names + "  (size " + names.size() + ")");

        Set<String> unique = new LinkedHashSet<>(names);
        List<String> cleaned = new ArrayList<>(unique);
        System.out.println("Without duplicates: " + cleaned + "  (size " + cleaned.size() + ")");

        System.out.println("TreeSet (sorted):   " + new TreeSet<>(names));

        Set<String> seen = new HashSet<>();
        for (String n : names) {
            if (!seen.add(n)) {
                System.out.println("Duplicate found: " + n);
            }
        }

        List<String> mixed = List.of("Tendai", "tendai", "TENDAI");
        System.out.println("Case-sensitive set size:   " + new HashSet<>(mixed).size());
        Set<String> ignoreCase = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        ignoreCase.addAll(mixed);
        System.out.println("Case-insensitive set size: " + ignoreCase.size());
    }
}
