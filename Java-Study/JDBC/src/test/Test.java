package test;

//导入包
import java.sql.*;

/*
 * 数据库连接
 */
public class Test {
    public static void main(String[] args) {

        /* url：统一资源定位符)
        包含的部分：
        协议：jdbc:mysql://
        IP：localhost为当前主机号或127.0.0.1
        PORT：3306
        资源名：test_schema 数据库名
        其他声明：时区要求、不使用SSL等 */
        String url = "jdbc:mysql://localhost:3306/test_schema?&useSSL=false&serverTimezone=UTC";
        // 用户名&密码
        String user = "root";
        String password = "123456";
        try {
            // 使用反射注册JDBC驱动程序（加载类时自动执行其static方法，注册就是一个静态方法）
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 也可以使用：DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            // 建立连接
            Connection connection = DriverManager.getConnection(url, user, password);
            if (!connection.isClosed()) {
                System.out.println("数据库连接成功");
            }
            // 创建一个Statement对象用来操作数据库
            Statement statement = connection.createStatement();
            // 编写SQL语句
            String selectAll = "select Sno,Sname from student;";
            // 将查询到的结果保存在结果集中进行统一处理
            ResultSet resultSet = statement.executeQuery(selectAll);
            /*
            statement.executeQuery();表示对语句进行查询操作
            statement.executeUpdate();表示对数据进行更新，返回值为int型表示影响的row数量
            */
            // 处理结果集
            while (resultSet.next()) {
                String No = resultSet.getNString("Sno");
                String Name = resultSet.getNString("Sname");

                System.out.println(No + '\t' + Name);
            }
            // 关闭连接（尽量对每一条判断关闭都进行try...catch...）
            if (!resultSet.isClosed()) {
                System.out.println("成功关闭ResultSet结果集");
                resultSet.close();
            }
            if (!statement.isClosed()) {
                System.out.println("成功关闭Statement对象");
                statement.close();
            }
            if (!connection.isClosed()) {
                System.out.println("成功关闭Connection对象");
                connection.close();
            }
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动没有安装");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("数据库连接失败");
        }
    }
}

