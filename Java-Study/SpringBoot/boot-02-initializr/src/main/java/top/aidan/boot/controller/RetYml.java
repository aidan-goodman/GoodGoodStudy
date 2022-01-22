package top.aidan.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.aidan.boot.bean.Person;

/**
 * Created by Aidan on 2021/9/18 17:11
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@RestController
public class RetYml {

    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person() {
        System.out.println(person.getUserName());
        return person;
    }

}
