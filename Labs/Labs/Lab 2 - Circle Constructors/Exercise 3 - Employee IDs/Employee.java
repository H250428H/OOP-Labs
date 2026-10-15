public class Employee {

    private static int nextId = 1;

    private final int employeeId;
    private final String name;
    private final String department;
    private final double salary;

    public Employee(String name, String department, double salary) {
        this.employeeId = nextId++;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Employee(String name, double salary) {
        this(name, "Unassigned", salary);
    }

    public Employee(String name) {
        this(name, 0.0);
    }

    public Employee(Employee other) {
        this(other.name, other.department, other.salary);
    }

    public int getEmployeeId() { return employeeId; }

    public static int getEmployeeCount() { return nextId - 1; }

    @Override
    public String toString() {
        return String.format("#%d  %-8s %-11s %8.2f", employeeId, name, department, salary);
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Tendai", "IT", 2500);
        Employee e2 = new Employee("Chipo", 1800);
        Employee e3 = new Employee("Farai");
        Employee e4 = new Employee(e1);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);
        System.out.println(e4);

        System.out.println("e1 == e4 ? " + (e1 == e4));
        System.out.println("Same id? " + (e1.getEmployeeId() == e4.getEmployeeId()));
        System.out.println("Employees created: " + Employee.getEmployeeCount());
    }
}
