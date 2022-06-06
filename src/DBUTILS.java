import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUTILS {

    private static String jdbcURL = "jdbc:mysql://localhost:3306/iiucsupershopdb";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "Anamul";

    public static Connection getConnection() {
        
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static ResultSet queryExecute(String query) throws Exception{
        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        return stmt.executeQuery(query);
    }
    
    public static int queryUpdate(String query) throws Exception{
        Connection connection = getConnection();
        Statement stmt = connection.createStatement();
        return stmt.executeUpdate(query);
    }
}