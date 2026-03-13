import java.util.*;

// Custom Exception
class OutOfStockException extends Exception {
    OutOfStockException(String msg) {
        super(msg);
    }
}

class Product {
    String productName;
    int stockQuantity;

    Product(String name, int stock) {
        productName = name;
        stockQuantity = stock;
    }

    void purchase(int quantity) throws OutOfStockException {

        if (quantity <= 0)
            throw new IllegalArgumentException("Quantity must be positive");

        if (quantity > stockQuantity)
            throw new OutOfStockException("Requested quantity exceeds stock");

        stockQuantity -= quantity;
        System.out.println("Purchase successful!");
        System.out.println("Remaining stock: " + stockQuantity);
    }
}

class pgm22 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter stock quantity: ");
        int stock = sc.nextInt();

        Product p = new Product(name, stock);

        System.out.print("Enter quantity to purchase: ");
        int qty = sc.nextInt();

        try {
            p.purchase(qty);
        }

        catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        catch (OutOfStockException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
/*
Enter product name: milk
Enter stock quantity: 30
Enter quantity to purchase: 5
Purchase successful!
Remaining stock: 25
user@user-OptiPlex-5000:~/Anns2$ cd "/home/user/Anns2/" && javac pgm22.java && java pgm22
Enter product name: biscuit
Enter stock quantity: 5
Enter quantity to purchase: 6
Error: Requested quantity exceeds stock
*/