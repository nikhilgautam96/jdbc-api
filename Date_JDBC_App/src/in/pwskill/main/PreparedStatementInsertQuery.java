package in.pwskill.main;

import in.pwskill.utility.JdbcUtil;

import java.sql.*;
import java.util.Scanner;

public class PreparedStatementInsertQuery {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        String sqlInsertQuery = "insert into student (sid, sname, sage, saddress) values(?,?,?,?);";

        try {
            connection = JdbcUtil.getDbConnection();
            if(connection != null) {
                preparedStatement = connection.prepareStatement(sqlInsertQuery);
            }
            if(preparedStatement != null) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter value of sid::");
                Integer sid = scanner.nextInt();
                System.out.print("Enter value of sname::");
                String sname = scanner.next();
                System.out.print("Enter value of sage::");
                Integer sage = scanner.nextInt();
                System.out.print("Enter value of saddress::");
                String saddress = scanner.next();

                // for preparedStatement object we need to inject the values.
                preparedStatement.setInt(1, sid);
                preparedStatement.setString(2, sname);
                preparedStatement.setInt(3, sage);
                preparedStatement.setString(4, saddress);

                int rowAffectedAfterInsert = preparedStatement.executeUpdate();
                if(rowAffectedAfterInsert == 1) {
                    System.out.println("Insertion Successful.");
                } else {
                    System.out.println("Record not updated to database...");
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
