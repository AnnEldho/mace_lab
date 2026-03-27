import java.sql.*;
import java.util.*;

public class BookDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Load driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Connection
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system", "manager");

            Statement stmt = con.createStatement();

            // Create table
            try {
                stmt.executeUpdate("CREATE TABLE book (bookid NUMBER PRIMARY KEY, title VARCHAR2(30), author VARCHAR2(30), price NUMBER)");
                System.out.println("Table created!");
            } catch (Exception e) {
                System.out.println("Table already exists.");
            }

            int ch;

            do {
                System.out.println("\n1.Insert\n2.Display All\n3.Search by Title\n4.Display by Author\n5.Update Price\n6.Delete\n7.Exit");
                System.out.print("Enter choice: ");
                ch = sc.nextInt();
                sc.nextLine();

                switch (ch) {

                    // 1. INSERT
                    case 1:
                        System.out.print("Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Author: ");
                        String author = sc.nextLine();

                        System.out.print("Price: ");
                        int price = sc.nextInt();
                        sc.nextLine();

                        stmt.executeUpdate("INSERT INTO book VALUES (" + id + ", '" + title + "', '" + author + "', " + price + ")");
                        System.out.println("Inserted!");
                        break;

                    // 2. DISPLAY ALL (FORMATTED)
                    case 2:
                        ResultSet rs1 = stmt.executeQuery("SELECT * FROM book");

                        System.out.println("\nID\tTitle\t\tAuthor\t\tPrice");
                        System.out.println("---------------------------------------------");

                        boolean found1 = false;

                        while (rs1.next()) {
                            found1 = true;
                            System.out.println(
                                rs1.getInt(1) + "\t" +
                                rs1.getString(2) + "\t\t" +
                                rs1.getString(3) + "\t\t" +
                                rs1.getInt(4)
                            );
                        }

                        if (!found1)
                            System.out.println("No records found.");

                        break;

                    // 3. SEARCH BY TITLE
                    case 3:
                        System.out.print("Enter title: ");
                        String t = sc.nextLine();

                        ResultSet rs2 = stmt.executeQuery("SELECT * FROM book WHERE title='" + t + "'");

                        System.out.println("\nID\tTitle\t\tAuthor\t\tPrice");
                        System.out.println("---------------------------------------------");

                        boolean found2 = false;

                        while (rs2.next()) {
                            found2 = true;
                            System.out.println(
                                rs2.getInt(1) + "\t" +
                                rs2.getString(2) + "\t\t" +
                                rs2.getString(3) + "\t\t" +
                                rs2.getInt(4)
                            );
                        }

                        if (!found2)
                            System.out.println("Book not found.");

                        break;

                    // 4. DISPLAY BY AUTHOR
                    case 4:
                        System.out.print("Enter author: ");
                        String a = sc.nextLine();

                        ResultSet rs3 = stmt.executeQuery("SELECT * FROM book WHERE author='" + a + "'");

                        System.out.println("\nID\tTitle\t\tAuthor\t\tPrice");
                        System.out.println("---------------------------------------------");

                        boolean found3 = false;

                        while (rs3.next()) {
                            found3 = true;
                            System.out.println(
                                rs3.getInt(1) + "\t" +
                                rs3.getString(2) + "\t\t" +
                                rs3.getString(3) + "\t\t" +
                                rs3.getInt(4)
                            );
                        }

                        if (!found3)
                            System.out.println("No books found.");

                        break;

                    // 5. UPDATE PRICE
                    case 5:
                        System.out.print("Enter book id: ");
                        int bid = sc.nextInt();

                        System.out.print("New price: ");
                        int newPrice = sc.nextInt();
                        sc.nextLine();

                        int rows1 = stmt.executeUpdate("UPDATE book SET price=" + newPrice + " WHERE bookid=" + bid);

                        if (rows1 > 0)
                            System.out.println("Updated!");
                        else
                            System.out.println("Book not found.");

                        break;

                    // 6. DELETE
                    case 6:
                        System.out.print("Enter book id: ");
                        int did = sc.nextInt();
                        sc.nextLine();

                        int rows2 = stmt.executeUpdate("DELETE FROM book WHERE bookid=" + did);

                        if (rows2 > 0)
                            System.out.println("Deleted!");
                        else
                            System.out.println("Book not found.");

                        break;

                }

            } while (ch != 7);

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

/*
user@user-OptiPlex-5000:~/Desktop/mace_lab-main/mace_lab/SEM 2/Java/JDBC/src$ javac -cp .:../lib/ojdbc17.jar BookDemo.java
user@user-OptiPlex-5000:~/Desktop/mace_lab-main/mace_lab/SEM 2/Java/JDBC/src$ java -cp .:../lib/ojdbc17.jar BookDemo
Table already exists.

1.Insert
2.Display All
3.Search by Title
4.Display by Author
5.Update Price
6.Delete
7.Exit
Enter choice: 2

ID      Title           Author          Price
---------------------------------------------
1       ABC             abc             200
2       XYZ             xyz             350
3       EFG             efg             150
4       Java            James           500

1.Insert
2.Display All
3.Search by Title
4.Display by Author
5.Update Price
6.Delete
7.Exit
Enter choice: 3
Enter title: abc

ID      Title           Author          Price
---------------------------------------------
Book not found.

1.Insert
2.Display All
3.Search by Title
4.Display by Author
5.Update Price
6.Delete
7.Exit
Enter choice: 4
Enter author: abc

ID      Title           Author          Price
---------------------------------------------
1       ABC             abc             200

1.Insert
2.Display All
3.Search by Title
4.Display by Author
5.Update Price
6.Delete
7.Exit
Enter choice: 5
Enter book id: 3
New price: 250
Updated!

1.Insert
2.Display All
3.Search by Title
4.Display by Author
5.Update Price
6.Delete
7.Exit
Enter choice: 6
Enter book id: 5
Book not found.

1.Insert
2.Display All
3.Search by Title
4.Display by Author
5.Update Price
6.Delete
7.Exit
Enter choice: 2

ID      Title           Author          Price
---------------------------------------------
1       ABC             abc             200
2       XYZ             xyz             350
3       EFG             efg             250
4       Java            James           500

1.Insert
2.Display All
3.Search by Title
4.Display by Author
5.Update Price
6.Delete
7.Exit
Enter choice: 6
Enter book id: 2
Deleted!

1.Insert
2.Display All
3.Search by Title
4.Display by Author
5.Update Price
6.Delete
7.Exit
Enter choice: 2

ID      Title           Author          Price
---------------------------------------------
1       ABC             abc             200
3       EFG             efg             250
4       Java            James           500

1.Insert
2.Display All
3.Search by Title
4.Display by Author
5.Update Price
6.Delete
7.Exit */