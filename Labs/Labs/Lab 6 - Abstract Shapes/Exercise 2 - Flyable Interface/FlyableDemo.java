interface Flyable {
    void fly();
}

class Bird implements Flyable {
    private final String species;
    Bird(String species) { this.species = species; }

    @Override
    public void fly() {
        System.out.println(species + " flaps its wings and takes off");
    }
}

class Aeroplane implements Flyable {
    private final String model;
    Aeroplane(String model) { this.model = model; }

    @Override
    public void fly() {
        System.out.println(model + " accelerates down the runway and lifts off");
    }
}

public class FlyableDemo {
    public static void main(String[] args) {

        Flyable[] flyers = { new Bird("African fish eagle"), new Aeroplane("Boeing 737"), new Bird("Hornbill") };

        for (Flyable f : flyers) {
            f.fly();
        }

        System.out.println("Bird extends: " + Bird.class.getSuperclass().getSimpleName());
        System.out.println("Aeroplane extends: " + Aeroplane.class.getSuperclass().getSimpleName());
    }
}
