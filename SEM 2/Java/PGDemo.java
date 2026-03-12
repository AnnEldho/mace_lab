import java.util.*;

// Showable interface
interface Showable {
    void show();
}

// Person class
class Person {
    String name, gender, phone;

    Person(String name, String gender, String phone) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
    }
}

// Student class
class Student extends Person {
    String course;
    double score;

    Student(String name, String gender, String phone,
            String course, double score) {

        super(name, gender, phone);
        this.course = course;
        this.score = score;
    }
}

// PGStudent class
class PGStudent extends Student implements Showable {
    String rarea;
    int gate;

    PGStudent(String name, String gender, String phone,
              String course, double score,
              String rarea, int gate) {

        super(name, gender, phone, course, score);
        this.rarea = rarea;
        this.gate = gate;
    }

    public void show() {
        System.out.println(name + "  " + course + "  " + score + "  " + rarea);
    }
}

// MAIN CLASS
class PGDemo {
    public static void main(String[] args) {

PGStudent[] PG = new PGStudent[5];

PG[0] = new PGStudent("Anu", "F", "9876", "MCA", 85, "AI", 400);
PG[1] = new PGStudent("Ravi", "M", "8765", "MCA", 78, "ML", 350);
PG[2] = new PGStudent("Meera", "F", "7654", "MCA", 92, "Data", 420);
PG[3] = new PGStudent("Arjun", "M", "6543", "MCA", 88, "ML", 390);
PG[4] = new PGStudent("Sneha", "F", "5432", "MCA", 81, "AI", 360);


        // Rank based on score
        Arrays.sort(PG, (s1, s2) -> Double.compare(s2.score, s1.score));

        System.out.println("\n--- Ranked by Score ---");
        for (PGStudent p : PG)
            p.show();

        // Sort based on research area
        Arrays.sort(PG, Comparator.comparing(s -> s.rarea));

        System.out.println("\n--- Sorted by Research Area ---");
        for (PGStudent p : PG)
            p.show();
    }
}
/*
--- Ranked by Score ---
Meera  MCA  92.0  Data
Arjun  MCA  88.0  ML
Anu  MCA  85.0  AI
Sneha  MCA  81.0  AI
Ravi  MCA  78.0  ML

--- Sorted by Research Area ---
Anu  MCA  85.0  AI
Sneha  MCA  81.0  AI
Meera  MCA  92.0  Data
Arjun  MCA  88.0  ML
Ravi  MCA  78.0  ML
*/