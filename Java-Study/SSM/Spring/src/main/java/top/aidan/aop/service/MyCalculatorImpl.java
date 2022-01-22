package top.aidan.aop.service;

import org.springframework.stereotype.Component;

/**
 * Created by Aidan on 2021/8/17 13:52
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Component
public class MyCalculatorImpl implements MyCalculator {
    // @Action
    @Override
    public int add(int a, int b) {
        // b = a / 0;   测试异常通知
        System.out.println(a + "+" + b + " = " + (a + b));
        return a + b;
    }

    @Override
    public void min(int a, int b) {
        System.out.println(a + "-" + b + " = " + (a - b));
    }
}
