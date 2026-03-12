import java.util.Scanner;

class Geometry {

    int area(int side) {
        return side * side;
    }

    int area(int length, int breadth) {
        return length * breadth;
    }

    double area(double radius) {
        return 3.14 * radius * radius;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Geometry g = new Geometry();

        // Square
        System.out.print("Enter side of square: ");
        int s = sc.nextInt();
        System.out.println("Area of Square: " + g.area(s));

        // Rectangle
        System.out.print("Enter length of rectangle: ");
        int l = sc.nextInt();
        System.out.print("Enter breadth of rectangle: ");
        int b = sc.nextInt();
        System.out.println("Area of Rectangle: " + g.area(l, b));

        // Circle
        System.out.print("Enter radius of circle: ");
        double r = sc.nextDouble();
        System.out.println("Area of Circle: " + g.area(r));

        sc.close();
    }
}
/*Enter side of square: 4
Area of Square: 16
Enter length of rectangle: 6
Enter breadth of rectangle: 5
Area of Rectangle: 30
Enter radius of circle: 5
Area of Circle: 78.5
 */