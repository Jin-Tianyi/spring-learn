package com.jty.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class HelloController {

    @GetMapping(value="/login")
    public ModelAndView Login() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","你好....");
        mv.setViewName("/test");
        return mv;
    }
    @GetMapping(value="/test")
    public ModelAndView test() throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","你好...");
        mv.setViewName("/test");
        return mv;
    }

    @PostMapping(value = "/upload")
    @ResponseBody
    public void upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        // 文件为空抛出异常
        if (file.isEmpty()) {
            throw new RuntimeException();
        }
        // 获取文件存储路径（绝对路径）
        String path = "D:\\Projects\\springmvc\\spring-mvc\\web\\WEB-INF\\file";
        // 获取原文件名
        String fileName = file.getOriginalFilename();
        // 创建文件实例
        File filePath = new File(path, fileName);
        // 如果文件目录不存在，创建目录
        if (!filePath.getParentFile().exists()) {
            filePath.getParentFile().mkdirs();
        }
        // 写入文件
        file.transferTo(filePath);
    }
}
