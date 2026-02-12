// Functional interface
@FunctionalInterface
interface DIM {
    double area(double x);
}

// MAIN CLASS
class LambdaDemo {
    public static void main(String[] args) {

        DIM square = x -> x * x;
        DIM cube = x -> 6 * x * x;
        DIM circle = x -> Math.PI * x * x;
        DIM sphere = x -> 4 * Math.PI * x * x;

        System.out.println("Area of Square : " + square.area(4));
        System.out.println("Area of Cube   : " + cube.area(4));
        System.out.println("Area of Circle : " + circle.area(3));
        System.out.println("Area of Sphere : " + sphere.area(3));
    }
}
/*
Area of Square : 16.0
Area of Cube   : 96.0
Area of Circle : 28.274333882308138
Area of Sphere : 113.09733552923255*/