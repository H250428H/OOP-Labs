import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextFileDemo {
    public static void main(String[] args) throws IOException {
        List<String> lines = new ArrayList<>();
        try (Scanner input = new Scanner(System.in)) {
            for (int i = 1; i <= 5; i++) {
                System.out.print("Enter line " + i + ": ");
                lines.add(input.nextLine());
            }
        }
        Path file = Path.of("lines.txt");
        Files.write(file, lines);
        System.out.println("Saved lines; reading them back:");
        for (String line : Files.readAllLines(file)) System.out.println(line);
    }
}
