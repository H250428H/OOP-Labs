import java.util.HashSet;
import java.util.List;
import java.util.Set;

record Student(String name, int age) { }

public class RecordDemo {
    public static void main(String[] args) {
        Student s1 = new Student("Tariro", 20);
        Student s2 = new Student("Tariro", 20);
        Student s3 = new Student("Farai", 22);

        System.out.println(s1);
        System.out.println("s1 == s2      : " + (s1 == s2));
        System.out.println("s1.equals(s2) : " + s1.equals(s2));
        System.out.println("s1.equals(s3) : " + s1.equals(s3));
        System.out.println("same hashCode : " + (s1.hashCode() == s2.hashCode()));

        System.out.println("name = " + s1.name() + ", age = " + s1.age());

        Set<Student> set = new HashSet<>(List.of(s1, s3));
        set.add(s2);
        System.out.println("Set size: " + set.size());

    }
}
