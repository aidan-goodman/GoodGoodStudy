package top.aidan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Aidan on 2021/8/18 20:39
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */

@Controller
public class FileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd/");

    @GetMapping("/helloTest")
    @ResponseBody
    public String hello() {
        return "hello";
    }

    @PostMapping("/upload")
    @ResponseBody
    public String fileUpload(MultipartFile file, HttpServletRequest req) {
        // 1.准备文件夹
        String format = sdf.format(new Date());
        String realPath = req.getServletContext().getRealPath("/") + format;
        File folder = new File(realPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
        // 2.准备文件名
        String oldName = file.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        // 3.存储
        try {
            file.transferTo(new File(folder, newName));
            // 4.组装 url
            String url = req.getScheme() + "://" + req.getServerName() +
                    ":" + req.getServerPort() + "/SpringMVC" + format + newName;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "error";
    }
}
