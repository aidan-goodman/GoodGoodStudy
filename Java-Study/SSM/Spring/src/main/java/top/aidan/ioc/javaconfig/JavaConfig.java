package top.aidan.ioc.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * Created by Aidan on 2021/8/15 22:10
 * <p>
 * GitHub github.com/huaxin0304
 * Blog aidanblog.top
 */

@Configuration
@ComponentScan(basePackages = "top.aidan.ioc", useDefaultFilters = false,
        includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Repository.class)})
public class JavaConfig {
    // Bean 默认名为方法名，这里是 sayHello
    // 可以通过 @Bean("anotherName") 的方式起别名
    @Bean
    SayHello sayHello() {
        return new SayHello();
    }
}
