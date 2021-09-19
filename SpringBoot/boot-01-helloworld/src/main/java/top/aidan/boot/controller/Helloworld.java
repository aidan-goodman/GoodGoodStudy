package top.aidan.boot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Aidan on 2021/9/17 20:08
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Slf4j
// RestController = Controller + ResponseBody
@RestController
public class Helloworld {

    @RequestMapping("/hello")
    public String handle01() {
        log.info("请求进来了");
        return "加油！！";
    }
}
