package com.example.takeaway.controller;

import com.example.takeaway.common.R;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/common")
public class CommonController {
    @Value("${reggie.path}")
    private String basePath;
    /**
     * 上传文件
     * @param file
     * @return
     */
    @PostMapping("/upload")
    public R<String > upload(MultipartFile file){
//        原始文件名
        String filename = file.getOriginalFilename();
        String suffix = filename.substring(filename.lastIndexOf("."));
//        使用uuid重新生成文件名，防止文件名重复造成文件覆盖
        String s = UUID.randomUUID() +suffix;
//        创建目录对象
        File dir = new File(basePath);
        if(!dir.exists()){
            dir.mkdirs();
        }
//        file是一个临时文件，需要转存到指定位置
        try {
            file.transferTo(new File(basePath+s));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.success(s);
    }

    /**
     * 文件下载
     * @param name
     * @param response
     */
    @GetMapping("/download")
    public void download(String name, HttpServletResponse response){
        try {
            File file = new File(basePath + name);
            if(!file.exists()){
                return;
            }
            //        输入流，读取文件内容
            FileInputStream fileInputStream = new FileInputStream(file);
            //        输出流，将文件写回
            ServletOutputStream outputStream = response.getOutputStream();

            response.setContentType("image/jpeg");

            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = fileInputStream.read(bytes)) != -1){
                outputStream.write(bytes,0,len);
                outputStream.flush();
            }
//            关闭流
            outputStream.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
