import java.awt.*;
import javax.swing.*;

// Interfaces
interface Printable {
    void print();
}

interface Computable {
    void compute();
}

interface Drawable {
    void draw();
}

// Rectangle class
class Rectangle implements Printable, Computable, Drawable {
    int length, width;

    Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public void print() {
        System.out.println("Rectangle");
        System.out.println("Length: " + length);
        System.out.println("Width : " + width);
    }

    public void compute() {
        System.out.println("Area of Rectangle: " + (length * width));
    }

    public void draw() {
        JFrame f = new JFrame("Rectangle");
        f.setSize(300, 300);
        f.add(new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawRect(50, 50, length, width);
            }
        });
        f.setVisible(true);
    }
}

// Sphere class
class Sphere implements Printable, Computable, Drawable {
    int radius;

    Sphere(int radius) {
        this.radius = radius;
    }

    public void print() {
        System.out.println("\nSphere");
        System.out.println("Radius: " + radius);
    }

    public void compute() {
        double volume = (4.0 / 3.0) * 3.14 * radius * radius * radius;
        System.out.println("Volume of Sphere: " + volume);
    }

    public void draw() {
        JFrame f = new JFrame("Sphere");
        f.setSize(300, 300);
        f.add(new JPanel() {
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawOval(50, 50, radius * 2, radius * 2);
            }
        });
        f.setVisible(true);
    }
}

// MAIN CLASS
class DrawDemo {
    public static void main(String args[]) {

        Rectangle r = new Rectangle(120, 80);
        r.print();
        r.compute();
        r.draw();

        Sphere s = new Sphere(60);
        s.print();
        s.compute();
        s.draw();
    }
}
/*Rectangle
Length: 120
Width : 80
Area of Rectangle: 9600

Sphere
Radius: 60
Volume of Sphere: 904320.0
*/