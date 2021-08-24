package top.aidan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import top.aidan.service.HelloService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Aidan on 2021/8/17 16:51
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */
// 为了让其注入到 SpringMVC 使用 Controller 配置
@org.springframework.stereotype.Controller("/hello")
public class MyController implements Controller {

    @Autowired
    HelloService helloService;

    /**
     * 此方法用来处理请求
     *
     * @param httpServletRequest  前端发送来的请求
     * @param httpServletResponse 服务端的响应
     * @return 返回 ModelAndView，Model 就相当于我们的 数据模型，View 则是视图
     * @throws Exception exception
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest,
                                      HttpServletResponse httpServletResponse) throws Exception {
        System.out.println(helloService.hello("aidan"));
        ModelAndView helloMV = new ModelAndView("hello");
        helloMV.addObject("name", "aidan");
        return helloMV;
    }
}
