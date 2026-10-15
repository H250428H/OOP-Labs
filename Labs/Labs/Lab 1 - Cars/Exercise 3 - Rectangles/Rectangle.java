public class Rectangle {

    double width;
    double height;

    double area()      { return width * height; }
    double perimeter() { return 2 * (width + height); }

    void display() {
        System.out.printf("%.1f x %.1f  area = %.2f  perimeter = %.2f%n",
                          width, height, area(), perimeter());
    }

    public static void main(String[] args) {

        Rectangle[] rects = new Rectangle[5];

        double[][] sizes = { {3, 4}, {5, 2}, {6, 6}, {2.5, 10}, {7, 1} };

        for (int i = 0; i < rects.length; i++) {
            rects[i] = new Rectangle();
            rects[i].width  = sizes[i][0];
            rects[i].height = sizes[i][1];
            System.out.print("Rectangle " + (i + 1) + ": ");
            rects[i].display();
        }

        Rectangle largest = rects[0];
        for (Rectangle r : rects) {
            if (r.area() > largest.area()) {
                largest = r;
            }
        }

        System.out.println("--- Largest area ---");
        largest.display();
    }
}
