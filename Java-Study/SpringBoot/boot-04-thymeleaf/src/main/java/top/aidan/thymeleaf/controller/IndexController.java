package top.aidan.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aidan.thymeleaf.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aidan on 2021/9/23 18:24
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(Model model) {
        List<User> userList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("Aidan " + i);
            user.setAddress(i + ".aidan.top");
            userList.add(user);
        }
        model.addAttribute("users", userList);
        return "index";
    }
}
