public class Circle {

    private static int count = 0;

    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
        count++;
    }

    public Circle() {
        this(1.0);
    }

    public static int getCount() {
        return count;
    }

    public double getRadius() { return radius; }
    public double area()      { return Math.PI * radius * radius; }

    public static void main(String[] args) {
        System.out.println("Circles before creating any: " + Circle.getCount());

        Circle a = new Circle(2.5);
        Circle b = new Circle();
        Circle c = new Circle(4);

        System.out.println("Circles after creating three: " + Circle.getCount());
        System.out.printf("b radius = %.1f, c area = %.2f%n", b.getRadius(), c.area());

        new Circle(7);
        System.out.println("After one more circle: " + Circle.getCount());
    }
}
