import java.util.Scanner;

class Zoo {
    String name;
    String[] regions;

    Zoo(String name, String[] regions) {
        this.name = name;
        this.regions = regions;
    }

    // Inner class
    class Enclosure {
        String name;
        String type;
        String[] animals;

        Enclosure(String name, String type, String[] animals) {
            this.name = name;
            this.type = type;
            this.animals = animals;
        }

        void display() {
            System.out.println("Enclosure Name: " + name);
            System.out.println("Type: " + type);
            System.out.print("Animals: ");
            for (int i = 0; i < animals.length; i++) {
                System.out.print(animals[i] + " ");
            }
            System.out.println();
        }
    }

    // Static nested class
    static class Contact {
        String address;
        String phone;

        Contact(String address, String phone) {
            this.address = address;
            this.phone = phone;
        }

        void display() {
            System.out.println("Address: " + address);
            System.out.println("Phone: " + phone);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        // Zoo details
        System.out.print("Enter Zoo Name: ");
        String zooName = sc.nextLine();

        System.out.print("Enter number of regions: ");
        int r = sc.nextInt();
        sc.nextLine();

        String[] regions = new String[r];
        for (int i = 0; i < r; i++) {
            System.out.print("Enter region " + (i + 1) + ": ");
            regions[i] = sc.nextLine();
        }

        Zoo zoo = new Zoo(zooName, regions);

        // Contact details
        System.out.print("Enter Address: ");
        String address = sc.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        Zoo.Contact contact = new Zoo.Contact(address, phone);

        // Enclosure details
        System.out.print("Enter number of enclosures: ");
        int e = sc.nextInt();
        sc.nextLine();

        Zoo.Enclosure[] enclosures = new Zoo.Enclosure[e];

        for (int i = 0; i < e; i++) {
            System.out.println("\nEnter details of Enclosure " + (i + 1));

            System.out.print("Enclosure Name: ");
            String ename = sc.nextLine();

            System.out.print("Enclosure Type: ");
            String type = sc.nextLine();

            System.out.print("Number of animals: ");
            int a = sc.nextInt();
            sc.nextLine();

            String[] animals = new String[a];
            for (int j = 0; j < a; j++) {
                System.out.print("Animal " + (j + 1) + ": ");
                animals[j] = sc.nextLine();
            }

            enclosures[i] = zoo.new Enclosure(ename, type, animals);
        }

        // Display output
        System.out.println("\n--- ZOO DETAILS ---");
        System.out.println("Zoo Name: " + zoo.name);

        System.out.print("Regions: ");
        for (int i = 0; i < zoo.regions.length; i++) {
            System.out.print(zoo.regions[i] + " ");
        }
        System.out.println();

        System.out.println("\n--- CONTACT DETAILS ---");
        contact.display();

        System.out.println("\n--- ENCLOSURE DETAILS ---");
        for (int i = 0; i < enclosures.length; i++) {
            enclosures[i].display();
            System.out.println();
        }

        sc.close();
    }
}

/*Enter Zoo Name: City Zoo
Enter number of regions: 1
Enter region 1: Area 1
Enter Address: Main Road,Kochi 
Enter Phone Number:  9876543210
Enter number of enclosures: 1

Enter details of Enclosure 1
Enclosure Name: Grassland
Enclosure Type: Outdoor
Number of animals: 2
Animal 1: Lion
Animal 2: Deer

--- ZOO DETAILS ---
Zoo Name: City Zoo
Regions: Area 1

--- CONTACT DETAILS ---
Address: Main Road,Kochi
Phone:  9876543210

--- ENCLOSURE DETAILS ---
Enclosure Name: Grassland
Type: Outdoor
Animals: Lion Deer
*/