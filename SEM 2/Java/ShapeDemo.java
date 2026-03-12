import java.util.Scanner;

// Interface
interface Shape {
    void area();
    void perimeter();
}

// Circle class
class Circle implements Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }

    public void area() {
        // Displays area of the circle
        System.out.println("Area of Circle = " + (3.14 * r * r));
    }

    public void perimeter() {
        // Displays perimeter of the circle
        System.out.println("Perimeter of Circle = " + (2 * 3.14 * r));
    }
}

// Rectangle class
class Rectangle implements Shape {
    double l, b;

    Rectangle(double l, double b) {
        this.l = l;
        this.b = b;
    }

    public void area() {
        // Displays area of the rectangle
        System.out.println("Area of Rectangle = " + (l * b));
    }

    public void perimeter() {
        // Displays perimeter of the rectangle
        System.out.println("Perimeter of Rectangle = " + (2 * (l + b)));
    }
}

// MAIN CLASS
class ShapeDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int ch;

        do {
            // Display menu options
            System.out.println("\n--- MENU ---");
            System.out.println("1. Circle");
            System.out.println("2. Rectangle");
            System.out.println("3. Exit");

            // Display message to enter choice
            System.out.print("Enter your choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    // Display message to enter radius
                    System.out.print("Enter radius: ");
                    double r = sc.nextDouble();

                    Shape c = new Circle(r);

                    // Display area and perimeter of circle
                    c.area();
                    c.perimeter();
                    break;

                case 2:
                    // Display message to enter length
                    System.out.print("Enter length: ");
                    double l = sc.nextDouble();

                    // Display message to enter breadth
                    System.out.print("Enter breadth: ");
                    double b = sc.nextDouble();

                    Shape rect = new Rectangle(l, b);

                    // Display area and perimeter of rectangle
                    rect.area();
                    rect.perimeter();
                    break;

                case 3:
                    // Display exit message
                    System.out.println("Exiting...");
                    break;

                default:
                    // Display invalid choice message
                    System.out.println("Invalid choice");
            }
        } while (ch != 3);

        sc.close();
    }
}
