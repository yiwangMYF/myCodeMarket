package cn.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description
 * @Author myf
 * @CreateDate 2020/12/8 9:46
 * @Version 1.0
 **/
@RestController
public class MyController {
    @RequestMapping("/test")
    public String test(){
        System.out.println("请求时间："+new Date().toString());
        return "test";
    }
}
