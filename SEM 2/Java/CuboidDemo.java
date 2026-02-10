// Interface to calculate volume
interface Measurable {
    void volume();
}

// Interface to display details
interface Printable {
    void display();
}

// Rectangle class
class Rectangle {
    double length, width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }
}

// Cuboid class inherits Rectangle and implements interfaces
class Cuboid extends Rectangle implements Measurable, Printable {
    double height;

    Cuboid(double length, double width, double height) {
        super(length, width);
        this.height = height;
    }

    // Implement volume method
    public void volume() {
        System.out.println("Volume of Cuboid = " + (length * width * height));
    }

    // Implement display method
    public void display() {
        System.out.println("Length  : " + length);
        System.out.println("Width   : " + width);
        System.out.println("Height  : " + height);
    }
}

// MAIN CLASS
class CuboidDemo {
    public static void main(String args[]) {

        Cuboid c = new Cuboid(10, 5, 4);

        c.display();
        c.volume();
    }
}
/*Length  : 10.0
Width   : 5.0
Height  : 4.0
Volume of Cuboid = 200.0
*/