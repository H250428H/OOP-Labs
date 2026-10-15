import java.util.*;

class Student implements Comparable<Student> {
    private final String name;
    private final int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    String getName() { return name; }
    int getMarks()   { return marks; }

    @Override
    public int compareTo(Student other) {
        return name.compareTo(other.name);
    }

    @Override
    public String toString() { return name + "(" + marks + ")"; }
}

class MarksComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        int byMarks = Integer.compare(a.getMarks(), b.getMarks());
        if (byMarks != 0) return byMarks;
        return a.getName().compareTo(b.getName());
    }
}

public class StudentSorting {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
            new Student("Kuda", 65), new Student("Ada", 91), new Student("Lynn", 78),
            new Student("Blessing", 65), new Student("Zodwa", 50)));

        Collections.sort(students);
        System.out.println("By name (Comparable):      " + students);

        students.sort(new MarksComparator());
        System.out.println("By marks (Comparator):      " + students);

        students.sort(Comparator.comparingInt(Student::getMarks).reversed()
                                .thenComparing(Student::getName));
        System.out.println("By marks, highest first:    " + students);
    }
}
