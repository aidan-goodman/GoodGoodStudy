package top.aidan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Aidan on 2021/8/18 23:26
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Controller
public class ControllerTest {
    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "hello";
    }
}
