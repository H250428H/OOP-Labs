public class PayrollDemo {

    static double totalPayroll(Employee[] staff) {
        double total = 0;
        for (Employee e : staff) {
            total += e.calculatePay();
        }
        return total;
    }

    public static void main(String[] args) {
        Employee[] before = {
            new Employee("Kudzai", 2000),
            new Manager("Nyasha", 3500, 800),
            new Developer("Tatenda", 3000, 10)
        };
        System.out.println("---- payroll WITHOUT an intern ----");
        System.out.printf("Total payroll: %.2f%n", totalPayroll(before));

        Employee[] after = {
            new Employee("Kudzai", 2000),
            new Manager("Nyasha", 3500, 800),
            new Developer("Tatenda", 3000, 10),
            new Intern("Rutendo", 600)
        };
        System.out.println("---- payroll WITH an intern ----");
        for (Employee e : after) {
            e.describe();
        }
        System.out.printf("Total payroll: %.2f%n", totalPayroll(after));
    }
}
