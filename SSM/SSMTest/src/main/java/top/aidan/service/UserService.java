package top.aidan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.aidan.mapper.UserMapper;
import top.aidan.model.User;

import java.util.List;

/**
 * Created by Aidan on 2021/8/24 21:45
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }
}
