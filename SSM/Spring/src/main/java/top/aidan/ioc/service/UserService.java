package top.aidan.ioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.aidan.ioc.dao.UserDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aidan on 2021/8/16 13:43
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

// 默认名为类名的首字母小写，使用 @Service("anotherName") 定义名字
@Service
public class UserService {
    @Autowired
    UserDao userDao;
    public List<String> getAllUsers() {
        String hello = userDao.hello();
        System.out.println(hello);

        List<String> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add("Aidan+" + i);
        }
        return users;
    }

}
