package studentLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BatchDeleteStudents {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/studentdb";
        String user = "root";
        String password = "001906";

        String deleteSQL = "DELETE FROM studentLibrary WHERE phone = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {

            // Delete student with phone '9812345678'
            pstmt.setString(1, "9841919430");
            pstmt.addBatch();

            // Delete student with phone '9823456799'
            pstmt.setString(1, "9823456799");
            pstmt.addBatch();

            // Delete student with phone '9834567870'
            pstmt.setString(1, "9834567870");
            pstmt.addBatch();

            // Execute batch delete
            int[] results = pstmt.executeBatch();

            System.out.println(results.length + " records deleted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
