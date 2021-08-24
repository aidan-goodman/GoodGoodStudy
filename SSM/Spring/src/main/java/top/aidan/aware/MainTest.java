package top.aidan.aware;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Aidan on 2021/8/17 11:17
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */
public class MainTest {
    @Test
    public void awareServiceTest() throws IOException {
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(JavaConfig.class);
        AwareService awareService = ctx.getBean(AwareService.class);
        awareService.outPut();
    }
}
