package in.pwskill.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteQuery {
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
        String sqlDeleteQuery = "delete from student where sid=11;";
        int rowAffected =  statement.executeUpdate(sqlDeleteQuery);

        // Process the resultSet.
        if(rowAffected == 1) {
            System.out.println("No of rows deleted is::"+rowAffected);
        } else {
            System.out.println("No successful deletion...");
        }

        // Close the resources
        statement.close();
        connection.close();

    }

}
