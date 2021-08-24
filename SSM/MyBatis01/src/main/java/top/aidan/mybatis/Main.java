package top.aidan.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import top.aidan.mybatis.model.User;

import java.io.IOException;
import java.util.List;

/**
 * Created by Aidan on 2021/8/23 9:44
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class Main {
    public static void main(String[] args) throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession();
        List<User> userList = sqlSession.selectList("top.aidan.mybatis.mapper.UserMapper.getAllUsers");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
}
