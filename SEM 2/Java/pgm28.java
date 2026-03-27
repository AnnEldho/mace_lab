import java.io.*;

// Employee class
class Employee implements Serializable {
    int id;
    String name, dept;
    double salary;

    Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

// Main class
class EmployeeDemo {
    public static void main(String[] args) throws Exception {

        // Create object
        Employee e = new Employee(101, "Ann", "IT", 50000);

        // Write object
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emp.dat"));
        oos.writeObject(e);
        oos.close();

        // Read object
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.dat"));
        Employee emp = (Employee) ois.readObject();
        ois.close();

        // Display
        System.out.println("ID: " + emp.id);
        System.out.println("Name: " + emp.name);
        System.out.println("Dept: " + emp.dept);
        System.out.println("Salary: " + emp.salary);
    }
}