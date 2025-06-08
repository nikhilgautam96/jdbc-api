package in.pwskill.utility;

import java.sql.*;

public class JdbcUtil {
    static {
        // load and register the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection getDbConnection() throws SQLException {
        // Establish the connection.
        String url = "jdbc:mysql://localhost:3306/pwskillsjavafullstackbatch";
        String user = "nikhil";
        String password = "personal8877";
        return DriverManager.getConnection(url, user, password);
    }
    public static void closeResources(ResultSet resultSet, Statement statement,
                                     Connection connection) throws SQLException {
        // Close Resource of allocated.
        if(resultSet != null) {
            resultSet.close();
        }
        if(statement != null) {
            statement.close();
        }
        if(connection != null) {
            connection.close();
        }
    }
}
