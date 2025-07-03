import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertMultipleStudents {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/studentdb";
        String user = "root";
        String password = "001906";

        String insertSQL = "INSERT INTO studentLibrary(name, age,gender,address,phone,email,enrollment) values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url,user,password);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL))    {

            pstmt.setString(1, "Sahil Bhattarai");
            pstmt.setInt(2, 23);
            pstmt.setString(3, "Female");
            pstmt.setString(4, "Bansbari");
            pstmt.setString(5, "9841919430");
            pstmt.setString(6, "sahil.bhattarai46@gmail.com");
            pstmt.setString(7, "2002-02-18");
            pstmt.addBatch();

            pstmt.setString(1, "Karan K.C");
            pstmt.setInt(2, 18);
            pstmt.setString(3, "Male");
            pstmt.setString(4, "Kathmandu");
            pstmt.setString(5, "9841043309");
            pstmt.setString(6, "karan09@gmail.com");
            pstmt.setString(7, "2023-01-01");
            pstmt.addBatch();

            int[] results = pstmt.executeBatch();
            System.out.println(results.length + " records inserted succesfully!");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
