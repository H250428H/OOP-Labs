abstract class Shape {
    abstract double area();
    abstract double perimeter();
}

class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    double area() {
        return Math.PI * radius * radius;
    }

    double perimeter() {
        return 2 * Math.PI * radius;
    }
}

class Rectangle extends Shape {
    protected final double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double area() {
        return width * height;
    }

    double perimeter() {
        return 2 * (width + height);
    }
}

class Square extends Rectangle {

    Square(double side) {
        super(side, side);
    }
}

public class ShapeAbstractionDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(2),
            new Rectangle(3, 4),
            new Square(3)
        };
        for (Shape shape : shapes) System.out.printf("%s: area %.2f, perimeter %.2f%n",
            shape.getClass().getSimpleName(), shape.area(), shape.perimeter());
    }
}
