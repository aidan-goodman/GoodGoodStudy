package top.aidan.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.aidan.admin.interceptor.LoginInterceptor;

/**
 * Created by Aidan on 2021/9/19 17:46
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/login", "/css/**",
                        "/fonts/**", "/images/**", "/js/**");
    }
}
