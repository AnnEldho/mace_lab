class Person{

    String name;

    Person(String name){
        this.name = name;
    }
}

class Employee extends Person{

    String designation;
    double salary;

    Employee(String name, String designation, double salary){

        super(name);

        this.designation = designation;
        this.salary = salary;
    }

    void printDetails(){

        System.out.println(name + " " + designation + " " + salary);
    }
}

class EmployeeThread extends Thread{

    Employee e[];

    EmployeeThread(Employee e[]){
        this.e = e;
    }

    public void run(){

        for(Employee x : e){

            x.printDetails();

            try{
                Thread.sleep(500);
            }

            catch(Exception ex){}
        }
    }
}

class VolumeThread extends Thread{

    int r[];

    VolumeThread(int r[]){
        this.r = r;
    }

    void printVolume(int x){

        double volume = (4.0/3.0) * 3.14 * x * x * x;

        System.out.println("Volume : " + volume);
    }

    public void run(){

        for(int x : r){

            printVolume(x);

            try{
                Thread.sleep(500);
            }

            catch(Exception e){}
        }
    }
}

public class Demo{

    public static void main(String[] args){

        Employee e[] = {

            new Employee("Ann","Manager",50000),
            new Employee("John","Clerk",25000)
        };

        int r[] = {2,3};

        EmployeeThread t1 = new EmployeeThread(e);

        VolumeThread t2 = new VolumeThread(r);

        t1.start();

        t2.start();
    }
}