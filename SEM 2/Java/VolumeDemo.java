// Comparable interface
interface Comparable {
    double volume();
    int compare(Comparable other);
}

// Cuboid class
class Cuboid implements Comparable {
    double l, b, h;

    Cuboid(double l, double b, double h) {
        this.l = l;
        this.b = b;
        this.h = h;
    }

    public double volume() {
        return l * b * h;
    }

    public int compare(Comparable other) {
        if (this.volume() > other.volume())
            return 1;
        else if (this.volume() < other.volume())
            return -1;
        else
            return 0;
    }
}

// Cylinder class
class Cylinder implements Comparable {
    double r, h;

    Cylinder(double r, double h) {
        this.r = r;
        this.h = h;
    }

    public double volume() {
        return Math.PI * r * r * h;
    }

    public int compare(Comparable other) {
        if (this.volume() > other.volume())
            return 1;
        else if (this.volume() < other.volume())
            return -1;
        else
            return 0;
    }
}

// MAIN CLASS
class VolumeDemo {
    public static void main(String[] args) {

        Comparable c1 = new Cuboid(4, 5, 6);
        Comparable c2 = new Cylinder(3, 7);

        System.out.println("Cuboid Volume   : " + c1.volume());
        System.out.println("Cylinder Volume : " + c2.volume());

        if (c1.compare(c2) > 0)
            System.out.println("Cuboid has greater volume");
        else
            System.out.println("Cylinder has greater volume");
    }
}
/*
Cuboid Volume   : 120.0
Cylinder Volume : 197.92033717615698
Cylinder has greater volume
*/