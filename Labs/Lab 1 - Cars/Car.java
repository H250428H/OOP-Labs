class Car {
    private final String brand;
    private final int year;
    private final double mileage;

    Car(String brand, int year, double mileage) {
        this.brand = brand;
        this.year = year;
        this.mileage = mileage;
    }

    void display() {
        System.out.printf("%s, year %d, mileage %.1f km%n", brand, year, mileage);
    }
}

public class Car1 {
    public static void main(String[] args) {
        Car[] cars = {
            new Car("Mercedes", 2017, 84000),
            new Car("Volkswagen", 2021, 39000),
            new Car("Audi", 2014, 126000)
        };
        for (Car car : cars) car.display();
    }
}
