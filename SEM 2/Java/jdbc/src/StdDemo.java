import java.sql.*;

public class StdDemo {
    public static void main(String[] args) {

        try {
            // Load driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Connection
            Connection con = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system", "manager");

            Statement stmt = con.createStatement();

            // 1. CREATE TABLE
            try {
                stmt.executeUpdate("CREATE TABLE std (id NUMBER PRIMARY KEY, name VARCHAR2(20))");
                System.out.println("Table std created!");
            } catch (Exception e) {
                System.out.println("Table already exists.");
            }

            // 2. INSERT
            stmt.executeUpdate("INSERT INTO std VALUES (2, 'Amina')");
            stmt.executeUpdate("INSERT INTO std VALUES (4, 'Apsara')");
            System.out.println("Data Inserted!");

            // 3. UPDATE
            stmt.executeUpdate("UPDATE std SET name='Meera' WHERE id=1");
            System.out.println("Data Updated!");

            // 4. DELETE
            stmt.executeUpdate("DELETE FROM std WHERE id=2");
            System.out.println("Data Deleted!");

            // 5. SELECT
            ResultSet rs = stmt.executeQuery("SELECT * FROM std");

            System.out.println("\n--- Table Data ---");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString(2));
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}