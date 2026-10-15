class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void display() {
        System.out.println("Name: " + name + ", age: " + age);
    }
}

class Student extends Person {
    private final String course;

    Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    @Override void display() {
        super.display();
        System.out.println("Course: " + course);
    }
}

public class PersonStudentDemo {
    public static void main(String[] args) {
        new Student("Ruva", 90, "Software Engineering").display();
    }
}
