import java.sql.*;

public class SingleConnectionCRUD {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pranawa";
        String user = "root";
        String password = "001906";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected!");

            // CREATE
            String insertSQL = "INSERT INTO student (id ,name,subject, age, address,marks) VALUES (?, ?, ?,?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                pstmt.setInt(1, 4);
                pstmt.setString(2, "Kabita");
                pstmt.setString(3, "DWDM");
                pstmt.setInt(4, 21);
                pstmt.setString(5, "Sitapaila");
                pstmt.setDouble(6,78.5);
                pstmt.executeUpdate();
                System.out.println("Inserted");
            }

            // READ
            String selectSQL = "SELECT * FROM student";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(selectSQL)) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + ": " + rs.getString("name"));
                }
            }

            // UPDATE
            String updateSQL = "UPDATE student SET age = ? WHERE name = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(updateSQL)) {
                pstmt.setInt(1, 22);
                pstmt.setString(2, "Kabita");
                pstmt.executeUpdate();
                System.out.println("Updated");
            }

            // DELETE
            String deleteSQL = "DELETE FROM student WHERE name = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                pstmt.setString(1, "Kabita");
                pstmt.executeUpdate();
                System.out.println("Deleted");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
