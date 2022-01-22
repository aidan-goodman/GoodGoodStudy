package top.aidan.service;

import org.springframework.stereotype.Service;

/**
 * Created by Aidan on 2021/8/17 22:59
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Service
public class HelloService {
    public String hello(String name) {
        return "hello " + name;
    }
}
