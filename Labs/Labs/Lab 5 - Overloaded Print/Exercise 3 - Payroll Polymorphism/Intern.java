public class Intern extends Employee {

    private static final double TRANSPORT_ALLOWANCE = 120.0;

    public Intern(String name, double stipend) {
        super(name, stipend);
        System.out.println("Intern constructor: " + name);
    }

    @Override
    public double calculatePay() {
        return super.calculatePay() + TRANSPORT_ALLOWANCE;
    }
}
