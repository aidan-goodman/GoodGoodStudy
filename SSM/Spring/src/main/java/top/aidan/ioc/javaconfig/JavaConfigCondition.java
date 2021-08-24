package top.aidan.ioc.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import top.aidan.ioc.condition.*;

/**
 * Created by Aidan on 2021/8/17 10:37
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */
@Configuration
public class JavaConfigCondition {
    @Bean("showCmd")
    @Conditional(WindowsCondition.class)
    ShowCmd winCmd() {
        return new WinShowCmd();
    }

    @Bean("showCmd")
    @Conditional(LinuxCondition.class)
    ShowCmd linuxCmd() {
        return new LinuxShowCmd();
    }
}
