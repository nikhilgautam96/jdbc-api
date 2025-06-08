package in.pwskill.main;

import java.sql.*;

public class InsertQuery {
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
        String sqlInsertQuery = "insert into student (sid, sname, sage, saddress) values(22, 'Rohit', 41, 'MI');";
        int rowAffected =  statement.executeUpdate(sqlInsertQuery);

        // Process the resultSet.
        if(rowAffected == 1) {
            System.out.println("No of rows affected is::"+rowAffected);
        } else {
            System.out.println("No successful insertion...");
        }

        // Close the resources
        statement.close();
        connection.close();

    }

}
