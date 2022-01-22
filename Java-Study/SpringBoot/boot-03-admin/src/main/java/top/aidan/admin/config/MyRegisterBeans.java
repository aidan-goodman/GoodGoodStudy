package top.aidan.admin.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.aidan.admin.controller.MyServlet;

/**
 * Created by Aidan on 2021/9/28 9:30
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Configuration
public class MyRegisterBeans {
   @Bean
   public ServletRegistrationBean<MyServlet> servlet(){
      MyServlet servlet=new MyServlet();
      return new  ServletRegistrationBean<>(servlet,"/servlet");
   }
}
