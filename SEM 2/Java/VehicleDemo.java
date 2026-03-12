abstract class Vehicle {
    String model, company;

    Vehicle(String model, String company) {
        this.model = model;
        this.company = company;
    }

    abstract void display();
}

class Car extends Vehicle {
    int doors;
    String fuelType;

    Car(String model, String company, int doors, String fuelType) {
        super(model, company);
        this.doors = doors;
        this.fuelType = fuelType;
    }

    void display() {
        System.out.println("Model: " + model);
        System.out.println("Company: " + company);
        System.out.println("Doors: " + doors);
        System.out.println("Fuel Type: " + fuelType);
    }
}

class Electric extends Car {
    int batteryCapacity;

    Electric(String model, String company, int doors,
             String fuelType, int batteryCapacity) {
        super(model, company, doors, fuelType);
        this.batteryCapacity = batteryCapacity;
    }

    void display() {
        super.display();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

class VehicleDemo {
    public static void main(String args[]) {

        Vehicle v;

        v = new Electric("Model X", "Tesla", 4, "Electric", 100);
        v.display();
    }
}
/*
Model: Model X
Company: Tesla
Doors: 4
Fuel Type: Electric
Battery Capacity: 100 kWh
 */
