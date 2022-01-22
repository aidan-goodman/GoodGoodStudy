package top.aidan.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Aidan on 2021/8/17 14:03
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Configuration
@ComponentScan
// 开启自动代理
@EnableAspectJAutoProxy
public class JavaConfig {
}
