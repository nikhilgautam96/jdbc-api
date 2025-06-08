package in.pwskill.main;

import java.sql.*;

public class SelectQuery {
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
//        String sqlSelectQuery = "use pwskillsjavafullstackbatch;select sid, sname, sage, saddress from student;";
        String sqlSelectQuery = "select sid, sname, sage, saddress from student;";
        ResultSet resultSet =  statement.executeQuery(sqlSelectQuery);

        System.out.println("SID\tSNAME\tSAGE\tSADDRESS");

        // Process the resultSet.
        while(resultSet.next()) {
            System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
                    resultSet.getInt(3)+"\t\t"+resultSet.getString(4));
        }

        // Close the resources
        resultSet.close();
        statement.close();
        connection.close();

    }
}