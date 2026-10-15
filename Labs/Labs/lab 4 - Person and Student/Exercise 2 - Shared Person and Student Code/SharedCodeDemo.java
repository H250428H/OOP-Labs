class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge()     { return age; }

    public void display() {
        System.out.println(getClass().getSimpleName() + ": " + name + ", age " + age);
    }
}

class Student extends Person {
    private final String course;

    Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }
    public String getCourse() { return course; }
}

class Teacher extends Person {
    private final String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    public String getSubject() { return subject; }
}

public class SharedCodeDemo {
    public static void main(String[] args) throws NoSuchMethodException {
        Student s = new Student("Tariro", 20, "Software Engineering");
        Teacher t = new Teacher("Mr Moyo", 41, "Mathematics");

        s.display();
        t.display();
        System.out.println(s.getName() + " studies " + s.getCourse());
        System.out.println(t.getName() + " teaches " + t.getSubject());

        System.out.println("Student.display() is declared in: "
                + Student.class.getMethod("display").getDeclaringClass().getSimpleName());
        System.out.println("Teacher.display() is declared in: "
                + Teacher.class.getMethod("display").getDeclaringClass().getSimpleName());

        System.out.println("s is a Person? " + (s instanceof Person));
        System.out.println("t is a Person? " + (t instanceof Person));
    }
}
