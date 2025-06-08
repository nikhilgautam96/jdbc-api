package in.pwskill.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateQuery {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        // Load and register the Driver.
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection.
        String url = "jdbc:mysql://localhost:3306/pwskillsjavafullstackbatch";
        String user = "nikhil";
        String password = "personal8877";
        Connection connection = DriverManager.getConnection(url, user, password);

        // Create a Statement Object.
        Statement statement = connection.createStatement();

        // Execute the query
        String sqlUpdateQuery = "update student set saddress='Mumbai' where sid=22;";
        int rowAffected =  statement.executeUpdate(sqlUpdateQuery);

        // Process the resultSet.
        if(rowAffected == 1) {
            System.out.println("No of rows updated is::"+rowAffected);
        } else {
            System.out.println("No successful update...");
        }

        // Close the resources
        statement.close();
        connection.close();

    }

}
