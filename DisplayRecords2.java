import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DisplayRecords2 {

    public static void main(String[] args) {

        try {
            Scanner sc = new Scanner(System.in);

            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/college",
                    "root",
                    "12345"
            );

            // Create Statement
            Statement stmt = con.createStatement();

            // Take query input
            System.out.print("ENTER A QUERY: ");
            String query = sc.nextLine().trim().toLowerCase();

            // If SELECT query
            if (query.startsWith("select")) {

                ResultSet rs = stmt.executeQuery(query);

                int cols = rs.getMetaData().getColumnCount();

                // Print column names
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%-15s", rs.getMetaData().getColumnName(i));
                }
                System.out.println();

                // Print data
                while (rs.next()) {
                    for (int i = 1; i <= cols; i++) {
                        System.out.printf("%-15s", rs.getString(i));
                    }
                    System.out.println();
                }

            } 
            // For INSERT / UPDATE / DELETE / CREATE
            else {

                int rows = stmt.executeUpdate(query);
                System.out.println("Query executed successfully, Rows affected: " + rows);

            }

            con.close();

        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
    }
}