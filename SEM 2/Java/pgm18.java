import java.util.*;

class Product {
    String name;
    double price;

    Product(String name, double price){
        this.name = name;
        this.price = price;
    }
@Override
    public String toString(){
        return name + "  " + price;
    }
}

class pgm18 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<>();
        int ch;

        do{
            System.out.println("\n---MENU---\n1.Add Product  2.Sort by Name  3.Display  4.Exit");
            ch = sc.nextInt();
            sc.nextLine();

            switch(ch){

                case 1:
                    System.out.print("Enter product name: ");
                    String n = sc.nextLine();
                    System.out.print("Enter price: ");
                    double p = sc.nextDouble();
                    list.add(new Product(n,p));
                    break;

                case 2:
                    list.sort(Comparator.comparing(x -> x.name));
                    System.out.println("Sorted");for(Product pr : list)
                        System.out.println(pr);
                    break;

                case 3:
                    for(Product pr : list)
                        System.out.println(pr);
                    break;
            }

        }while(ch != 4);
    }
}

/*
1.Add Product  2.Sort by Name  3.Display  4.Exit
1
Enter product name: milk
Enter price: 30

1.Add Product  2.Sort by Name  3.Display  4.Exit
1
Enter product name: biscuit
Enter price: 20

1.Add Product  2.Sort by Name  3.Display  4.Exit
1
Enter product name: rice
Enter price: 45

1.Add Product  2.Sort by Name  3.Display  4.Exit
2
Sorted

1.Add Product  2.Sort by Name  3.Display  4.Exit
3
biscuit  20.0
milk  30.0
rice  45.0

1.Add Product  2.Sort by Name  3.Display  4.Exit
4
PS C:\Users\HP\Desktop\MACE\mace_lab\SEM 2\Java> javac pgm18.java
PS C:\Users\HP\Desktop\MACE\mace_lab\SEM 2\Java> java pgm18      

1.Add Product  2.Sort by Name  3.Display  4.Exit
1
Enter product name: milk
Enter price: 30

1.Add Product  2.Sort by Name  3.Display  4.Exit
1
Enter product name: biscuit
Enter price: 20

1.Add Product  2.Sort by Name  3.Display  4.Exit
1
Enter product name: rice
Enter price: 45

1.Add Product  2.Sort by Name  3.Display  4.Exit
2
Sorted
biscuit  20.0
milk  30.0
rice  45.0

1.Add Product  2.Sort by Name  3.Display  4.Exit
3
biscuit  20.0
milk  30.0
rice  45.0
*/