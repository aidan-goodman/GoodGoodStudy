package top.aidan.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Aidan on 2021/9/25 19:19
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts() {
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) {
        log.info("email={},username={},headerImg={},photos={}",
                email, username, headerImg.getSize(), photos.length);

        if (!headerImg.isEmpty()) {
            String originalFilename = headerImg.getOriginalFilename();
            try {
                headerImg.transferTo(new File("C:\\Data Files\\Config Files\\FileCacheTest\\" + originalFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    try {
                        photo.transferTo(new File("C:\\Data Files\\Config Files\\FileCacheTest\\" + photo.getOriginalFilename()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "main";
    }
}
