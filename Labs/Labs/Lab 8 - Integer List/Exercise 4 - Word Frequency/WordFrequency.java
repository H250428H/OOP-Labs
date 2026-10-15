import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Type a paragraph, then press Enter on an empty line to finish:");

        StringBuilder paragraph = new StringBuilder();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (line.isBlank()) break;
            paragraph.append(line).append(' ');
        }

        String[] words = paragraph.toString().toLowerCase().split("[^a-z']+");

        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            if (!w.isEmpty()) {
                freq.merge(w, 1, Integer::sum);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(freq.entrySet());
        entries.sort((a, b) -> {
            int byCount = Integer.compare(b.getValue(), a.getValue());
            return byCount != 0 ? byCount : a.getKey().compareTo(b.getKey());
        });

        for (Map.Entry<String, Integer> e : entries) {
            System.out.printf("%-6s %d%n", e.getKey(), e.getValue());
        }
        System.out.println("Distinct words: " + entries.size());
    }
}
