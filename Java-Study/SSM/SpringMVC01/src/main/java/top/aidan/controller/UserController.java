package top.aidan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Aidan on 2021/8/18 10:37
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/getuser")
    public ModelAndView getUser() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", "userName");
        return mv;
    }
}
