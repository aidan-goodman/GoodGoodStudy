package top.aidan.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Aidan on 2021/9/23 18:39
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Controller
public class JsController {
    @GetMapping("/js")
    public String js(Model model) {
        model.addAttribute("username", "Aidan");
        return "js";
    }
}
