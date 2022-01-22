package top.aidan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import top.aidan.mybatis.model.Book;

/**
 * Created by Aidan on 2021/8/18 10:43
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Controller
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/getbook")
    public ModelAndView getBook() {
        ModelAndView mv = new ModelAndView("hello");
        mv.addObject("name", "bookName");
        return mv;
    }

    @GetMapping("/book")
    public String book() {
        return "addbook";
    }

    @PostMapping(value = "/addbook", produces = "text/html;charset=utf-8")
    @ResponseBody
    public String addBook(String name, String author, Double price) {
        return name + author + price;
    }

    @PostMapping(value = "/addBookBean", produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addBookBean(Book book) {
        return book.toString();
    }
}
