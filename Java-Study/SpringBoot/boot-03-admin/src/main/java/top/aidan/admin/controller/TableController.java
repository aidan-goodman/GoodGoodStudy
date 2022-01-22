package top.aidan.admin.controller;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Aidan on 2021/9/19 16:44
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Controller
public class TableController {

    @GetMapping("/basic_table")
    public String basic_table(Model model) {
        // 全局异常处理测试
        // int a=1/0;

        // 使用 model 信息更改前端 li 标签的 class
        model.addAttribute("flag","0");
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
        model.addAttribute("flag","1");
        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table(Model model) {
        model.addAttribute("flag","2");
        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(Model model) {
        model.addAttribute("flag","3");
        return "table/editable_table";
    }
}
