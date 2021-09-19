package top.aidan.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aidan on 2021/9/18 16:31
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@RestController
public class Hello {

    @RequestMapping("/hello")
    public String hello(@RequestParam("name") String name){
        return "你好："+name;
    }
}
