public class SQLConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String username="root";
        String password="001906";
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println(" Connection Sucessful");
        }catch (ClassNotFoundException e){
            System.out.println("Connection Failed");
        }
    }
}
