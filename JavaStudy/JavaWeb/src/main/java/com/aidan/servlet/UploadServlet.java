/*
package com.aidan.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 判断是否为多段数据
        if (ServletFileUpload.isMultipartContent((RequestContext) req)) {
            // 创建一个FileItemFactory的实现类对象
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建解析数据的工具类
            ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);
            // 解析多段数据放到List集合中
            try {
                List<FileItem> fileItems = fileUpload.parseRequest((RequestContext) req);
                // 循环判断表单项是普通类型还是文件
                for (FileItem fileItem : fileItems) {
                    if (fileItem.isFormField()) {
                        // 普通表单项
                        System.out.println("表单项的name：" + fileItem.getFieldName());
                        // 进行中文编码
                        System.out.println("表单项的value：" + fileItem.getString("UTF-8"));

                    } else {
                        // 文件
                        System.out.println("表单项的name：" + fileItem.getFieldName());
                        System.out.println("文件名：" + fileItem.getName());

                        // 将文件写入到磁盘
                        fileItem.write(new File("C:\\Users\\xiao\\Downloads" + fileItem.getName()));
                    }
                }

            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
*/
