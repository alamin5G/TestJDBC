import com.mysql.jdbc.Driver;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String pass = "252646";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully!");
        }catch (ClassNotFoundException c){
            System.err.println("com.mysql..cj.jdbc.Driver - not found/loaded successfully!-- " + c.getMessage());
        }

        try{
            Connection connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connection established success with Database!");
            Statement statement = connection.createStatement();
            String query = "select * from student";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String address = resultSet.getString(3);
                System.out.println("The " + id + " id's Student name is " + name + " and his/her address is " + address);
            }
            statement.close();
            resultSet.close();
        }catch (SQLException s){
            System.err.println("Database Connection Failed - " + s.getMessage());
        }
    }
}