package studentLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabaseExample {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "001906";
        String Query = "CREATE DATABASE IF NOT EXISTS studentdb";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(Query);
            System.out.println("Database 'studentdb', created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}