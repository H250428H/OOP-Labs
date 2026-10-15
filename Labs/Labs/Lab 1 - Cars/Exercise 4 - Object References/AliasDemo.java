public class AliasDemo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        r1.width = 5;
        r1.height = 3;

        Rectangle r2 = r1;
        r2.width = 10;

        System.out.println("r1.width = " + r1.width);
        System.out.println("r1 == r2 ? " + (r1 == r2));

        Rectangle r3 = new Rectangle();
        r3.width  = r1.width;
        r3.height = r1.height;
        r3.width  = 99;

        System.out.println("r1.width after changing r3 = " + r1.width);
        System.out.println("r1 == r3 ? " + (r1 == r3));
    }
}
