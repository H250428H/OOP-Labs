class Animal {

    String sound() { return "..."; }
}

class Cat extends Animal {
    @Override String sound() { return "Meow"; }
}

class Cow extends Animal {
    @Override String sound() { return "Moo"; }
}

class Duck extends Animal {
    @Override String sound() { return "Quack"; }
}

public class AnimalSounds {
    public static void main(String[] args) {

        Animal[] farm = { new Cat(), new Cow(), new Duck(), new Animal() };

        for (Animal a : farm) {

            System.out.println(a.getClass().getSimpleName() + " says " + a.sound());
        }
    }
}
