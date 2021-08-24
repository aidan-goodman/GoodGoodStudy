package top.aidan.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.aidan.ioc.model.User;

/**
 * Created by Aidan on 2021/8/15 11:16
 *
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */
public class Main {
    public static void main(String[] args) {
        /* 传统创建 JavaBean 对象方式
        User user = new User();
        System.out.println("User is :" + user);
        */
        // 指向配置路径所在的方法，配置文件自动执行
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // method1(context);
        /*
        User user2 = context.getBean("user2", User.class);
        System.out.println(user2);
        */
        /*
        User user3 = context.getBean("user3", User.class);
        System.out.println(user3);
        */

        User user4 = context.getBean("user4", User.class);
        System.out.println("这时"+user4);
    }

    private static void method1(ClassPathXmlApplicationContext context) {
        // 获取 JavaBean 方式一
        User user1 = (User) context.getBean("user");
        // 获取二：传入类，无需强转
        User user2 = context.getBean("user", User.class);
        // 获取三：直接按类型获取，但有重名类时比较麻烦
        User user3 = context.getBean(User.class);

        System.out.println("User1 is :" + user1);
        System.out.println("User2 is :" + user2);
        System.out.println("User3 is :" + user3);
        /* 结果如下，全是同一个对象
        User1 is :top.aidan.ioc.model.User@bcec361
        User2 is :top.aidan.ioc.model.User@bcec361
        User3 is :top.aidan.ioc.model.User@bcec361
        */
    }
}
