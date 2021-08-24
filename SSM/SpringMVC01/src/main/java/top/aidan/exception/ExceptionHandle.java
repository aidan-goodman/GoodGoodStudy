package top.aidan.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Aidan on 2021/8/18 22:12
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(Exception.class)
    public ModelAndView fileUploadSizeLimit(Exception e) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("error", e.getMessage());
        return mv;
    }
}
