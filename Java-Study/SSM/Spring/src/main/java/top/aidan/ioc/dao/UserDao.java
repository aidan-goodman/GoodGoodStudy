package top.aidan.ioc.dao;

import org.springframework.stereotype.Repository;

/**
 * Created by Aidan on 2021/8/16 14:05
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Repository
public class UserDao {
    public String hello() {
        return "hello Auto";
    }
}
