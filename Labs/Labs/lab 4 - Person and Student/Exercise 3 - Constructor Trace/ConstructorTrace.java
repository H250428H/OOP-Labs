class Vehicle {
    protected final String brand;

    Vehicle(String brand) {
        this.brand = brand;
        System.out.println("1. Vehicle constructor: brand = " + brand);
        printActiveConstructors();
    }

    private static void printActiveConstructors() {
        StringBuilder chain = new StringBuilder();
        for (StackTraceElement frame : Thread.currentThread().getStackTrace()) {
            if (frame.getMethodName().equals("<init>")) {
                if (chain.length() > 0) chain.append(" <- ");
                chain.append(frame.getClassName());
            }
        }
        System.out.println("   open constructors (innermost first): " + chain);
    }
}

class Car extends Vehicle {
    protected final int doors;

    Car(String brand, int doors) {
        super(brand);
        this.doors = doors;
        System.out.println("2. Car constructor: doors = " + doors);
    }
}

class ElectricCar extends Car {
    private final int batteryKwh;

    ElectricCar(String brand, int doors, int batteryKwh) {
        super(brand, doors);
        this.batteryKwh = batteryKwh;
        System.out.println("3. ElectricCar constructor: battery = " + batteryKwh + " kWh");
    }
}

public class ConstructorTrace {
    public static void main(String[] args) {
        System.out.println("Creating an ElectricCar...");
        new ElectricCar("Nissan Leaf", 5, 40);

        System.out.println("--- Creating a plain Car ---");
        new Car("Toyota Hilux", 4);
    }
}
