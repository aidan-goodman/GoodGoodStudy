package top.aidan.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;
import top.aidan.aop.service.MyCalculator;

/**
 * Created by Aidan on 2021/8/17 14:04
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class MainTest {
    @Test
    public void aspectTest() {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(JavaConfig.class);
        MyCalculator calculator = ctx.getBean(MyCalculator.class);
        calculator.add(3, 4);
        System.out.println("============------------============");
        calculator.min(10, 3);
    }

    @Test
    public void aspectXmlTest() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyCalculator calculator = ctx.getBean(MyCalculator.class);
        calculator.add(6, 7);
        calculator.min(4, 2);
    }
}
