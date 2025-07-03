import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
public class InsertDB {
        public static void main(String[] args) {
            String url = "jdbc:mysql://localhost:3306/pranawa";
            String user = "root";
            String password = "001906";
            String query = "INSERT INTO student(id,name,subject,age,address,marks)VALUES(2,'Sahil','POM',22,'Pasikot',45)";
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection(url,user,password);
                System.out.println("Connection Successfull");

                //create statement
                Statement stmt = conn.createStatement();
                //execute update
                int rowsAffected = stmt.executeUpdate(query);

                //check result

                if(rowsAffected>0){
                    System.out.println("Insert Successful. Rows affected: "+rowsAffected);
                }else{
                    System.out.println("Insert failed");
                }

                stmt.close();
                conn.close();
                System.out.println("Connection closed Succesfully");
            }catch(ClassNotFoundException e){
                System.out.println("MySql JDBC driver not founds");
                e.printStackTrace();
            }catch(SQLException e){
                System.out.println("Connection failed");
                e.printStackTrace();
            }
        }
}
