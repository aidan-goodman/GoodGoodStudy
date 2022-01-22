package top.aidan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.aidan.model.User;
import top.aidan.service.UserService;

import java.util.List;

/**
 * Created by Aidan on 2021/8/24 21:48
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
