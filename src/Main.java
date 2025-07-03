import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/pranawa";
            String user = "root";
            String password = "001906";
            String query = "SELECT * FROM pranawa.student";
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url,user,password);
                System.out.println("Connection Successfull");


                //statement is used to send sql queries to the database.
                Statement stmt= conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String subject = rs.getString("subject");
                    int age = rs.getInt("age");
                    String address = rs.getString("address");
                    double marks = rs.getDouble("marks");

                    System.out.println(" ");
                    System.out.println("ID: "+id);
                    System.out.println("Name: "+name);
                    System.out.println("Subject: "+subject);
                    System.out.println("Age: "+age);
                    System.out.println("Address: "+address);
                    System.out.println("Marks: "+marks);

                }

                conn.close();
                rs.close();
                stmt.close();
                System.out.println();
                System.out.println("Connection closed Successfully");
            } catch (ClassNotFoundException e) {
                System.out.println("MySql JDBC driver not founds");
                e.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Connection failed");
                e.printStackTrace();
            }

    }
}