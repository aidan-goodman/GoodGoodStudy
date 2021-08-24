package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_schema?&useSSL=false&serverTimezone=UTC", "root", "123456");

            // 关闭Connection的自动提交
            connection.setAutoCommit(false);

            String sqlStr = "";
            preparedStatement = connection.prepareStatement(sqlStr);
            preparedStatement.setString(1, "");
            preparedStatement.executeUpdate();

            // 手动进行事务提交
            connection.commit();

        } catch (Exception e) {

            // 中间异常回滚
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
        } finally {
            try {
                if (!preparedStatement.isClosed()) {
                    System.out.println("成功关闭Statement对象");
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (!connection.isClosed()) {
                    System.out.println("成功关闭Connection对象");
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
