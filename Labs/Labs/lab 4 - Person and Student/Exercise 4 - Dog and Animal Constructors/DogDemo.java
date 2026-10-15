class Dog extends Animal {

    Dog(String name) {
        super(name);
        System.out.println("Dog created: " + getName());
    }

    Dog() {
        super("Unnamed dog");
        System.out.println("Dog created: " + getName());
    }
}

public class DogDemo {
    public static void main(String[] args) {
        new Dog("Rex");
        new Dog();
    }
}
