package top.aidan.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.aidan.ioc.condition.ShowCmd;
import top.aidan.ioc.javaconfig.JavaConfig;
import top.aidan.ioc.javaconfig.JavaConfigCondition;
import top.aidan.ioc.javaconfig.SayHello;
import top.aidan.ioc.service.UserService;

import java.util.List;

/**
 * Created by Aidan on 2021/8/15 22:11
 *
 * @GitHub github.com/huaxin0304
 * @Blog aidanblog.top
 */
public class JavaConfigTest {
    public static void main(String[] args) {

        // method1();

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(JavaConfigCondition.class);
        ShowCmd showCmd = (ShowCmd) ctx.getBean("showCmd");
        System.out.println(showCmd.showCmd());

    }

    private static void method1() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(JavaConfig.class);
        SayHello hello = ctx.getBean(SayHello.class);
        System.out.println(hello.sayHello("aidan"));

        UserService userService = ctx.getBean(UserService.class);
        List<String> allUsers = userService.getAllUsers();
        System.out.println(allUsers);
    }
}
