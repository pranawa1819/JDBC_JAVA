import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTableStudentLibrary {
    public static void main(String[] args) {
        // Database connection parameters
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "001906";

        // SQL to create the table
        String sql = "CREATE TABLE IF NOT EXISTS studentlibrary (" +
                "id INT PRIMARY KEY AUTO_INCREMENT, " +
                "name VARCHAR(50) NOT NULL, " +
                "age INT, " +
                "gender VARCHAR(10), " +
                "address VARCHAR(100), " +
                "phone VARCHAR(15) UNIQUE, " +
                "email VARCHAR(100) UNIQUE, " +
                "enrollment DATE" +
                ")";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            // Execute the SQL statement
            stmt.executeUpdate(sql);
            System.out.println("Table 'studentlibrary' created successfully in database 'studentdb'.");

        } catch (Exception e) {
            System.err.println("Error creating table: ");
            e.printStackTrace();
        }
    }
}