package top.aidan.admin.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by Aidan on 2021/9/23 19:31
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class AidanProperties {
    @Value("${top.aidan.name}")
    private String name;

    public void show(){
        System.out.println(this.name);
    }
}
