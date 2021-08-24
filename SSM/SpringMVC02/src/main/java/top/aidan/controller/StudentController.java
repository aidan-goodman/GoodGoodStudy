package top.aidan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import top.aidan.mybatis.model.Student;
import top.aidan.validation.ValidationGroup1;

import java.util.List;

/**
 * Created by Aidan on 2021/8/19 0:01
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Controller
public class StudentController {
    @PostMapping("/student")
    public void addStudent(@Validated(ValidationGroup1.class) Student student, BindingResult result) {
        System.out.println(student);
        if (result.hasErrors()) {
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError allError : allErrors) {
                System.out.println("allError.getDefaultMessage() = " + allError.getDefaultMessage());
            }
        }
    }
}
