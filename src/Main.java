import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/Student";
        String user = "root";
        String pass = "252646";

        try(Connection connection = DriverManager.getConnection(url, user, pass)) {
            System.out.println("Database connected Successfully!");
        } catch (SQLException e) {
            System.err.println("Connection Failed: " + e.getMessage());
        }
    }
}