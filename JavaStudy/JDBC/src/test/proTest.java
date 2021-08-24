package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class proTest {
    public static void main(String[] args) {
        // 绑定配置文件
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jdbc");
        try {
            Class.forName(resourceBundle.getString("driver"));
            //根据键获取值
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String password = resourceBundle.getString("password");

            Connection connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                System.out.println("连接成功");
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
