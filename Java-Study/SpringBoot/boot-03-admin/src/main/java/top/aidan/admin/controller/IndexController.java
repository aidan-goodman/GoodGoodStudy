package top.aidan.admin.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import top.aidan.admin.bean.User;

import javax.servlet.http.HttpSession;

/**
 * Created by Aidan on 2021/9/19 15:39
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Controller
public class IndexController {
    /**
     * 登录页、首页
     *
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {


        if (StringUtils.hasLength(user.getUserName()) && "123".equals(user.getPassword())) {
            session.setAttribute("loginUser", user);
            // 重定向到 main.html，防止刷新重复提交表单（最简单解决重复提交的方式）
            // return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "用户名密码错误！");
            return "login";
        }

        // 统一使用拦截器
        return "main";
    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "请先登录");
            return "login";
        }
    }
}
