import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteStudentLibrary {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "001906";

        // Example: Delete a record where phone = '9812345678'
        String deleteSQL = "DELETE FROM studentLibrary WHERE phone = '9804595670'";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            int rowsDeleted = stmt.executeUpdate(deleteSQL);

            if (rowsDeleted > 0) {
                System.out.println("Record deleted successfully!");
            } else {
                System.out.println("No matching record found to delete.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}