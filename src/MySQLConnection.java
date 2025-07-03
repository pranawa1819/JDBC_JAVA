import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


public class MySQLConnection {
    public static void main(String[] args) {
        String url ="jdbc:mysql://localhost:3306/pranawa";
        String user ="root";
        String password ="001906";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            //open a connection
            Connection conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connection Successfull");
            conn.close();
        }catch(ClassNotFoundException e){
            System.out.println("MySql JDBC driver not founds");
            e.printStackTrace();
        }catch(SQLException e){
            System.out.println("Connection failed");
            e.printStackTrace();
        }
    }
}
