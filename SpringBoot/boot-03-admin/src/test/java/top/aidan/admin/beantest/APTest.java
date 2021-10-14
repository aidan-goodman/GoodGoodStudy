package top.aidan.admin.beantest;

import org.junit.jupiter.api.Test;
import top.aidan.admin.bean.AidanProperties;

/**
 * Created by Aidan on 2021/9/23 19:33
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

public class APTest {
    @Test
    public void Test1() {
        AidanProperties aidanProperties = new AidanProperties();
        aidanProperties.show();
    }
}
