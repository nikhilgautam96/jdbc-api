package in.pwskill.main;

import in.pwskill.utility.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementUpdateQuery {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sqlUpdateQuery = "update student set sname=?, sage=?, saddress=? where sid=?;";

        try {
            connection = JdbcUtil.getDbConnection();
            if(connection != null) {
                preparedStatement = connection.prepareStatement(sqlUpdateQuery);
            }
            if(preparedStatement != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter sid of record that needs to be updated::");
                Integer sid = scanner.nextInt();
                System.out.print("Enter new value of sname::");
                String sname = scanner.next();
                System.out.print("Enter new value of sage::");
                Integer sage = scanner.nextInt();
                System.out.print("Enter new value of saddress::");
                String saddress = scanner.next();

                // for preparedStatement object we need to inject the values.
                preparedStatement.setInt(4, sid);
                preparedStatement.setString(1, sname);
                preparedStatement.setInt(2, sage);
                preparedStatement.setString(3, saddress);

                int rowAffectedAfterInsert = preparedStatement.executeUpdate();
                if(rowAffectedAfterInsert == 1) {
                    System.out.println("Update Successful.");
                } else {
                    System.out.println("Record not found, invalid sid:: "+sid);
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
