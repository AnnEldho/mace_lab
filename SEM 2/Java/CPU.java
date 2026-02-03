import java.util.Scanner;

class CPU {
    int price;

    CPU(int price) {
        this.price = price;
    }

    // Inner class
    class Processor {
        int cores;
        String manufacturer;

        Processor(int cores, String manufacturer) {
            this.cores = cores;
            this.manufacturer = manufacturer;
        }

        void display() {
            System.out.println("Processor Cores: " + cores);
            System.out.println("Processor Manufacturer: " + manufacturer);
        }
    }

    // Static nested class
    static class RAM {
        int memory;
        String manufacturer;

        RAM(int memory, String manufacturer) {
            this.memory = memory;
            this.manufacturer = manufacturer;
        }

        void display() {
            System.out.println("RAM Memory: " + memory + " GB");
            System.out.println("RAM Manufacturer: " + manufacturer);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // CPU input
        System.out.print("Enter CPU price: ");
        int price = sc.nextInt();
        sc.nextLine();

        CPU cpu = new CPU(price);

        // Processor input
        System.out.print("Enter number of cores: ");
        int cores = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter processor manufacturer: ");
        String pman = sc.nextLine();

        CPU.Processor processor = cpu.new Processor(cores, pman);

        // RAM input
        System.out.print("Enter RAM memory (GB): ");
        int memory = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter RAM manufacturer: ");
        String rman = sc.nextLine();

        CPU.RAM ram = new CPU.RAM(memory, rman);

        // Display details
        System.out.println("\n--- CPU DETAILS ---");
        System.out.println("CPU Price: " + cpu.price);
        processor.display();
        ram.display();

        sc.close();
    }
}


/*OUTPUT:
Enter CPU price: 45000
Enter number of cores: 8
Enter processor manufacturer: Intel
Enter RAM memory (GB): 16
Enter RAM manufacturer: Samsung

--- CPU DETAILS ---
CPU Price: 45000
Processor Cores: 8
Processor Manufacturer: Intel
RAM Memory: 16 GB
RAM Manufacturer: Samsung
*/