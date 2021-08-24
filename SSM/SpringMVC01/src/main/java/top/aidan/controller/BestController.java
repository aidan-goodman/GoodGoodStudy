package top.aidan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Aidan on 2021/8/18 10:21
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Controller
public class BestController {
    @RequestMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", "aidan");
        return mv;
    }
}
