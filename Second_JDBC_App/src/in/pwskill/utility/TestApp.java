package in.pwskill.utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestApp {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sqlSelectQuery = "select sid, sname, sage, saddress from student;";
        String sqlInsertQuery = "insert into student (sid, sname, sage, saddress) values(9, 'Shreyas', 22, 'PBKS');";
        String sqlUpdateQuery = "update student set sname='Tendulkar', saddress='Wankhede' where sid=12;";
        String sqlDeleteQuery = "delete from student where sid=11;";

        try {
            connection = JdbcUtil.getDbConnection();
            if(connection != null) {
                statement = connection.createStatement();
            }
            if(statement != null) {
                // select query
                resultSet = statement.executeQuery(sqlSelectQuery);
                // Process the resultSet.
                if(resultSet != null) {
                    while(resultSet.next()) {
                        System.out.println(resultSet.getInt(1)+"\t"+resultSet.getString(2)+"\t"+
                                resultSet.getInt(3)+"\t\t"+resultSet.getString(4));
                    }
                }

                // insert query
                int rowAffectedAfterInsert =  statement.executeUpdate(sqlInsertQuery);
                // Process the resultSet.
                if(rowAffectedAfterInsert == 1) {
                    System.out.println("No of rows affected is::"+rowAffectedAfterInsert);
                } else {
                    System.out.println("No successful insertion...");
                }

                // update query
                int rowAffectedAfterUpdate =  statement.executeUpdate(sqlUpdateQuery);
                // Process the resultSet.
                if(rowAffectedAfterUpdate == 1) {
                    System.out.println("No of rows updated is::"+rowAffectedAfterUpdate);
                } else {
                    System.out.println("No successful update...");
                }

                // delete query
                int rowAffectedAfterDelete =  statement.executeUpdate(sqlDeleteQuery);

                // Process the resultSet.
                if(rowAffectedAfterDelete == 1) {
                    System.out.println("No of rows deleted is::"+rowAffectedAfterDelete);
                } else {
                    System.out.println("No successful deletion...");
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
