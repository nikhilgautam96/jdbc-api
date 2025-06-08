package in.pwskill.main;

import in.pwskill.utility.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementDeleteQuery {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sqlDeleteQuery = "delete from student where sid=?;";

        try {
            connection = JdbcUtil.getDbConnection();
            if(connection != null) {
                preparedStatement = connection.prepareStatement(sqlDeleteQuery);
            }
            if(preparedStatement != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter value of sid::");
                Integer sid = scanner.nextInt();

                // for preparedStatement object we need to inject the values.
                preparedStatement.setInt(1, sid);

                int rowAffectedAfterInsert = preparedStatement.executeUpdate();
                if(rowAffectedAfterInsert == 1) {
                    System.out.println("Deletion Successful.");
                } else {
                    System.out.println("Record not available for deletion with sid:: "+sid);
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
