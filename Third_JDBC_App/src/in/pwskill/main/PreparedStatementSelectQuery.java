package in.pwskill.main;

import in.pwskill.utility.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementSelectQuery {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sqlSelectQuery = "select sid, sname, sage, saddress from student where sid = ?;";

        try {
            connection = JdbcUtil.getDbConnection();
            if(connection != null) {
                preparedStatement = connection.prepareStatement(sqlSelectQuery);
            }
            if(preparedStatement != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter value of sid::");
                Integer sid = scanner.nextInt();

                // for preparedStatement object we need to inject the values.
                preparedStatement.setInt(1, sid);

                resultSet = preparedStatement.executeQuery();
                // Process the resultSet.
                if(resultSet != null) {
                    while(resultSet.next()) {
                        System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
                                resultSet.getInt(3)+"\t\t"+resultSet.getString(4));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //Closing the resources
            try {
                JdbcUtil.closeResources(resultSet, statement, connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
