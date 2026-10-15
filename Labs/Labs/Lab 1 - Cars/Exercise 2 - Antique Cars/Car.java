import java.time.Year;

public class Car {

    String brand;
    int year;
    int mileage;

    void display() {
        System.out.println(brand + " (" + year + ") - " + mileage + " km");
    }

    boolean isAntique() {
        return isAntique(Year.now().getValue());
    }

    boolean isAntique(int currentYear) {
        return currentYear - year > 25;
    }

    public static void main(String[] args) {
        Car c1 = new Car();
        c1.brand = "Peugeot 404";
        c1.year = 1968;
        c1.mileage = 310000;

        Car c2 = new Car();
        c2.brand = "Toyota Corolla";
        c2.year = 2015;
        c2.mileage = 140000;

        Car c3 = new Car();
        c3.brand = "Honda Fit";
        c3.year = 2022;
        c3.mileage = 45000;

        c1.display();
        c2.display();
        c3.display();

        System.out.println(c1.brand + " antique? " + c1.isAntique());
        System.out.println(c2.brand + " antique? " + c2.isAntique());
        System.out.println(c3.brand + " antique? " + c3.isAntique());

        Car edge = new Car();
        edge.brand = "Test car";
        edge.year = 2001;
        System.out.println("2001 car in 2026 (age 25): " + edge.isAntique(2026));
        System.out.println("2001 car in 2027 (age 26): " + edge.isAntique(2027));
    }
}
