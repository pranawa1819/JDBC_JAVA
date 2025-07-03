package Teacher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteDataOfTeacher {

    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/pranawa"; // Replace with your DB name
        String user = "root";  // Replace with your DB username
        String password = "001906";  // Replace with your DB password

        // SQL delete query
        String query = "DELETE FROM employees WHERE id = 2";

        try {
            // Load JDBC driver (optional for JDBC 4.0+)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("DBConnection successful!");

            // Create statement
            Statement stmt = conn.createStatement();

            // Execute update
            int rowsAffected = stmt.executeUpdate(query); //insert,update, delete

            // Check result
            if (rowsAffected > 0) {
                System.out.println("Delete Successful. Rows affected: " + rowsAffected);
            } else {
                System.out.println("No matching record found. Delete skipped.");
            }

            // Close resources
            stmt.close();
            conn.close();
            System.out.println("DBConnection closed successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL Exception occurred.");
            e.printStackTrace();
        }
    }
}