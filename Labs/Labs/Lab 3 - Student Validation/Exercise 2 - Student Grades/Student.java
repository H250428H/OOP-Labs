public class Student {

    private static final int A_MIN = 70;
    private static final int B_MIN = 60;
    private static final int C_MIN = 50;

    private String name;
    private int marks;

    public Student(String name, int marks) {
        setName(name);
        setMarks(marks);
    }

    public String getName()  { return name; }
    public int getMarks()    { return marks; }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name required");
        }
        this.name = name.trim();
    }

    public void setMarks(int marks) {
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be 0 to 100 but was " + marks);
        }
        this.marks = marks;
    }

    public String getGrade() {
        if (marks >= A_MIN) return "A";
        if (marks >= B_MIN) return "B";
        if (marks >= C_MIN) return "C";
        return "F";
    }

    public static void main(String[] args) {
        int[] testMarks = {100, 70, 69, 60, 59, 50, 49, 0};
        for (int m : testMarks) {
            Student s = new Student("Test", m);
            System.out.printf("marks %3d -> grade %s%n", s.getMarks(), s.getGrade());
        }

        Student tariro = new Student("Tariro", 82);
        System.out.println(tariro.getName() + ": " + tariro.getMarks() + " = " + tariro.getGrade());
        tariro.setMarks(45);
        System.out.println(tariro.getName() + ": " + tariro.getMarks() + " = " + tariro.getGrade());

        try {
            tariro.setMarks(105);
        } catch (IllegalArgumentException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
        System.out.println("Marks are still " + tariro.getMarks());
    }
}
