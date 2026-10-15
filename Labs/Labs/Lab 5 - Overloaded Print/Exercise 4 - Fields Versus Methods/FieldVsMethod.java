class Phone {
    String type = "Basic phone";

    String describe() {
        return "makes calls";
    }
}

class Smartphone extends Phone {
    String type = "Smartphone";

    @Override
    String describe() {
        return "makes calls and runs apps";
    }

    String bothTypes() {
        return type + " / " + super.type;
    }
}

public class FieldVsMethod {
    public static void main(String[] args) {
        Phone p = new Smartphone();

        System.out.println("p.describe()  -> " + p.describe());
        System.out.println("p.type        -> " + p.type);

        Smartphone s = (Smartphone) p;
        System.out.println("s.type        -> " + s.type);
        System.out.println("s.bothTypes() -> " + s.bothTypes());
    }
}
