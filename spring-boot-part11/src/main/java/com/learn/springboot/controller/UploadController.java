package com.learn.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @program: spring-boot-part11
 * @package: com.learn.springboot.controller
 * @classname: UploadController
 * @description:
 * @author: zbb
 * @create: 2022-02-25
 */
@Slf4j
@Controller
public class UploadController {

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    /**
     * 初始化上传文件界面，跳转到index.html
     * @return
     */
    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }

    /**
     * 提取上传方法为公共方法
     * @param uploadDir 上传文件目录
     * @param file 上传对象
     * @throws Exception
     */
    private String executeUpload(String uploadDir,MultipartFile file) throws Exception
    {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
//        String prefix = file.getOriginalFilename().substring(file.getOriginalFilename()("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
        return   filename;
    }

    /**
     * 上传文件方法
     * @param file 前台上传的文件对象
     * @return
     */
    @PostMapping(value = "/upload")
    public  String  upload(HttpServletRequest request,MultipartFile file)
    {
        String path="";
        try {
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadFolder);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //调用上传方法
            path =executeUpload(uploadFolder,file);
        }catch (Exception e)
        {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }

        return "redirect:" +"upload"+File.separator+path ;
    }

    /**
     * 下载图片
     * @param fileName
     * @param response
     * @throws Exception
     */
    @GetMapping("/download")
    public void downloadFile(String fileName, HttpServletResponse response) throws Exception {
        // 1.去指定目录读取文件
        File file = new File(uploadFolder, fileName);
        // 2.将文件读取为文件输入流
        FileInputStream is = new FileInputStream(file);
        // 2.1 获取响应流之前  一定要设置以附件形式下载
        response.setHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        // 3.获取响应输出流
        ServletOutputStream os = response.getOutputStream();
        FileCopyUtils.copy(is,os);
    }

//    @GetMapping(value = "/downloadCSV")
//    public ResponseEntity<byte[]> downloadCSV() throws IOException {
//        HttpHeaders h = new HttpHeaders();
//        h.add("Content-Type", "text/csv; charset=GBK");
//        h.setContentDispositionFormData("filename", "foobar.csv");
//
//
//        // 1.去指定目录读取文件
//        File file = new File(uploadFolder, "1.png");
//        // 2.将文件读取为文件输入流
//        FileInputStream is = new FileInputStream(file);
//
//        // 3.获取响应输出流
//        ServletOutputStream os = response.getOutputStream();
//        FileCopyUtils.copy(is,os);
//
//    }


}
