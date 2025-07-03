import CommonConnection.DBConnection;

import java.sql.*;

public class JDBCPipelines {

    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false); // Transaction start

            try {
                insertData(conn);
                updateData(conn);
                readData(conn);

                conn.commit();  // Commit transaction
                System.out.println("Pipeline completed successfully.");
            } catch (Exception e) {
                conn.rollback(); // Rollback on error
                e.printStackTrace();
                System.out.println("Pipeline rolled back due to error.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void insertData(Connection conn) throws SQLException {
        String sql = "INSERT INTO students (name, age, email) VALUES (?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "Alice");
            ps.setInt(2, 20);
            ps.setString(3, "alice@example.com");
            ps.executeUpdate();
            System.out.println("Inserted data");
        }
    }

    static void updateData(Connection conn) throws SQLException {
        String sql = "UPDATE students SET age = ? WHERE name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, 21);
            ps.setString(2, "Alice");
            ps.executeUpdate();
            System.out.println("Updated data");
        }
    }

    static void readData(Connection conn) throws SQLException {
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Student: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            }
        }
    }
}
