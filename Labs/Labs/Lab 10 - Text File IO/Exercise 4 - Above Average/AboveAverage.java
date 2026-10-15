import java.util.List;
import java.util.stream.Collectors;

record Student(String name, double marks) { }

public class AboveAverage {
    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Tariro", 82), new Student("Farai", 55), new Student("Rudo", 91),
            new Student("Kuda", 67),   new Student("Ada", 74),   new Student("Blessing", 48),
            new Student("Nyasha", 70));

        double average = students.stream()
                                 .mapToDouble(Student::marks)
                                 .average()
                                 .orElse(0);
        System.out.printf("Class average: %.2f%n", average);

        System.out.println("Above average, in alphabetical order:");
        students.stream()
                .filter(s -> s.marks() > average)
                .map(Student::name)
                .sorted()
                .forEach(name -> System.out.println("  " + name));

        String joined = students.stream()
                .filter(s -> s.marks() > average)
                .map(Student::name)
                .sorted()
                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("As one line: " + joined);
    }
}
