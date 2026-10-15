import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class TextStats {
    public static void main(String[] args) {

        Path path = Path.of(args.length > 0 ? args[0] : "sample.txt");

        try {
            if (args.length == 0) {
                Files.writeString(path,
                    "Java is object-oriented.\nIt runs on the JVM.\n\nWrite once, run anywhere!\n");
            }

            int lines = 0, words = 0, chars = 0, charsNoSpaces = 0;

            try (var reader = Files.newBufferedReader(path)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines++;
                    chars += line.length();
                    charsNoSpaces += line.replaceAll("\\s", "").length();
                    if (!line.isBlank()) {
                        words += line.trim().split("\\s+").length;
                    }
                }
            }

            System.out.println("File: " + path);
            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters (with spaces): " + chars);
            System.out.println("Characters (without spaces): " + charsNoSpaces);

        } catch (NoSuchFileException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }
}
